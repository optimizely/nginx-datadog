// Unless explicitly stated otherwise all files in this repository are licensed
// under the Apache License Version 2.0.
// This product includes software developed at Datadog (https://www.datadoghq.com/).
// Copyright 2016-present Datadog, Inc.

package e2etests

import (
	"bytes"
	"flag"
	"fmt"
	runneros "os"
	"path/filepath"
	"reflect"
	"runtime"
	"strings"
	"testing"

	"github.com/DataDog/datadog-agent/test/new-e2e/pkg/e2e"
	"github.com/DataDog/datadog-agent/test/new-e2e/pkg/environments"
	awshost "github.com/DataDog/datadog-agent/test/new-e2e/pkg/environments/aws/host"
	"github.com/DataDog/test-infra-definitions/components/os"
	"github.com/DataDog/test-infra-definitions/scenarios/aws/ec2"
	"golang.org/x/net/html"
)

var (
	assetDir     string
	devMode      *bool = flag.Bool("devmode", false, "Set to true to enable devmode")
	skipSigCheck *bool = flag.Bool("skipSigCheck", false, "Set to true to skip verification of the installer & dll signatures")
)

type vmSuite struct {
	e2e.BaseSuite[environments.Host]
}

type iisSite struct {
	name                 string
	port                 string
	assets               []string
	expectedResponsePath string
}

func init() {
	// Get the absolute path to the test assets directory
	// Note that injector_IIS_installer.msi will automatically get copied to the test asset directory when you build it in VS
	currDir, _ := runneros.Getwd()
	assetDir = filepath.Join(currDir, "test_assets")
}

func TestVMSuite(t *testing.T) {
	suiteParams := []e2e.SuiteOption{e2e.WithProvisioner(awshost.ProvisionerNoAgentNoFakeIntake(awshost.WithEC2InstanceOptions(ec2.WithOS(os.WindowsDefault))))}
	if *devMode {
		suiteParams = append(suiteParams, e2e.WithDevMode())
	}

	e2e.Run(t, &vmSuite{}, suiteParams...)
}

func (v *vmSuite) TestInjectorIIS() {
	v.T().Run("Install", v.testInstall)
	v.T().Run("Register module", v.testModuleRegistration)
	v.T().Run("Test injection", v.testSuccessfulInjection)
	v.T().Run("Uninstall", v.testUninstall)
}

func (v *vmSuite) testInstall(t *testing.T) {
	vm := v.Env().RemoteHost

	// Copy the injector installer to the VM
	remoteFilePath := filepath.Join(remoteInstallerPath, installerName)
	vm.CopyFile(filepath.Join(assetDir, installerName), remoteFilePath)

	// Run the installer
	if runtime.GOOS != "windows" {
		// because remoteFilePath is constructed at runtime, we have to convert it to a windows path if the test runner is linux
		remoteFilePath = strings.Replace(remoteFilePath, "/", "\\", -1)
	}
	vm.Execute(fmt.Sprintf("Start-Process msiexec '/i %s /qn /norestart' -Wait", remoteFilePath))

	// Verify installer put the injector DLL in the right place
	v.T().Logf("Checking for injector DLL at '%s'\n", defaultBinPath)
	res := strings.TrimSpace(vm.MustExecute(fmt.Sprintf("Test-Path -Path '%s'", defaultBinPath)))
	v.Require().Equal("True", res)

	// Verify the injector DLL has the right permissions
	v.T().Logf("Checking injector DLL permissions at '%s'\n", defaultBinPath)
	accessMatches, err := isBasicFileAccessEqual(vm, defaultBinPath, expectedBinAccess)
	v.Require().NoError(err)
	v.Require().True(accessMatches)

	// Verify the installler and injector DLL are both signed
	if !(*skipSigCheck) {
		installerSignature := getBinarySignature(vm, remoteFilePath)
		v.Assert().Equal("Valid", installerSignature)
		dllSignature := getBinarySignature(vm, defaultBinPath)
		v.Assert().Equal("Valid", dllSignature)
	}

	// Verify the installer put the injector config in the right place
	v.T().Logf("Checking for injector config at '%s'\n", exampleConfigPath)
	res = strings.TrimSpace(vm.MustExecute(fmt.Sprintf("Test-Path -Path '%s'", exampleConfigPath)))
	v.Assert().Equal("True", res)

	// Verify the installer wrote the correct configuration
	v.T().Logf("Checking that installer wrote correct configuration path to registry (should be default)")
	res = getConfigFileFromRegistry(vm)
	v.Assert().Equal(defaultConfigDir, res)

	// Verify the injector config has the right permissions
	v.T().Logf("Checking injector config permissions at '%s'\n", exampleConfigPath)
	accessMatches, err = isBasicFileAccessEqual(vm, exampleConfigPath, expectedConfigAccess)
	v.Require().NoError(err)
	v.Require().True(accessMatches)

	// verify the registry key has the right permissions
	v.T().Logf("Checking injector registry permissions at '%s'\n", defaultConfigLocation)
	actualAccess, err := getBasicFileAccess(vm, getConfigRegistryPath())
	v.Require().NoError(err)
	accessMatches, err = isRegistryWritableAccessEqual(expectedRegKeyAccess, actualAccess)
	v.Require().NoError(err)
	v.Require().True(accessMatches)

	// verify that the installer wrote the config location key
	v.T().Logf("Checking for data directory key\n")
	configuredPath := getConfigFileFromRegistry(vm)
	v.Assert().Equal(defaultConfigDir, configuredPath)
}

func (v *vmSuite) testModuleRegistration(t *testing.T) {
	vm := v.Env().RemoteHost

	v.T().Log("Installing IIS")
	err := installIIS(vm)
	v.Require().NoError(err)

	v.T().Log("Registering RUM module")
	err = registerIISModule(v.Env().RemoteHost, defaultModuleName, defaultBinPath)
	v.Require().NoError(err)
}

func (v *vmSuite) testSuccessfulInjection(t *testing.T) {
	vm := v.Env().RemoteHost

	sitesToTest := []iisSite{
		{
			name: "Default Site", // tests simple injection
			port: "8080",
			assets: []string{
				filepath.Join(assetDir, "default_site", "iisstart.htm"),
				filepath.Join(assetDir, "default_site", "iisstart.png"),
			},
			expectedResponsePath: filepath.Join(assetDir, "default_site", "expected-response-with-injection.txt"),
		},
		{
			name: "Large Site", // tests injection into large response
			port: "8081",
			assets: []string{
				filepath.Join(assetDir, "large_site", "index.html"),
			},
			expectedResponsePath: filepath.Join(assetDir, "large_site", "expected-response-with-injection.txt"),
		},
	}

	for _, site := range sitesToTest {
		v.T().Log("Creating IIS site \"" + site.name + "\"")
		err := createIISSite(vm, site.name, site.port, site.assets)
		v.Require().NoError(err)

		v.T().Log("Creating injection configuration file for site \"" + site.name + "\"")
		vm.Execute("New-Item -Path \"" + defaultConfigDir + "\" -Name \"" + site.name + "\" -ItemType \"directory\"")
		localConfigFilePath := filepath.Join(assetDir, "test-config.json")
		remoteFilePath := filepath.Join(defaultConfigDir, site.name, defaultConfigName)
		vm.CopyFile(localConfigFilePath, remoteFilePath)

		v.T().Log("Restarting IIS server")
		vm.Execute("iisreset /restart")

		// Query site & validate that injection occurred
		v.T().Log("Testing injection into \"" + site.name + "\"")
		response := vm.MustExecute("(iwr -UseBasicParsing http://localhost:" + site.port + ").Content")
		responseHTML, err := html.Parse(strings.NewReader(response))
		v.Assert().NoError(err)

		expectedResponse, _ := runneros.ReadFile(site.expectedResponsePath)
		expectedResponseHTML, err := html.Parse(bytes.NewReader(expectedResponse))
		v.Assert().NoError(err)

		v.Assert().True(reflect.DeepEqual(expectedResponseHTML, responseHTML), "Expected response: \n%s\n\n Actual response: \n%s", expectedResponse, response)

		// Validate that the injection header is present
		v.T().Log("Testing injection headers")
		responseHeaders := vm.MustExecute("(iwr -UseBasicParsing http://localhost:" + site.port + ").Headers")
		v.Assert().Contains(responseHeaders, "x-datadog-rum-injected")
	}
}

func (v *vmSuite) testUninstall(t *testing.T) {
	vm := v.Env().RemoteHost

	// Uninstall the injector
	remotePath := filepath.Join(remoteInstallerPath, installerName)
	vm.MustExecute(fmt.Sprintf("Start-Process msiexec '/x %s /qn /norestart' -Wait", remotePath))

	// Verify the injector DLL is gone
	res := strings.TrimSpace(vm.MustExecute(fmt.Sprintf("Test-Path -Path '%s'", defaultBinPath)))
	v.Assert().Equal("False", res)

	// Verify the injector config is still around
	res = strings.TrimSpace(vm.MustExecute(fmt.Sprintf("Test-Path -Path '%s'", exampleConfigPath)))
	v.Assert().Equal("True", res)

	// verify the registry hive is gone
	cmd := fmt.Sprintf("get-item -erroraction silentlycontinue \"%s\" ; $?", getConfigRegistryPath())
	res = strings.TrimSpace(vm.MustExecute(cmd))
	v.Assert().Equal("False", res)
}
