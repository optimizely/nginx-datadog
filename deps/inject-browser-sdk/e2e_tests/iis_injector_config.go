// Unless explicitly stated otherwise all files in this repository are licensed
// under the Apache License Version 2.0.
// This product includes software developed at Datadog (https://www.datadoghq.com/).
// Copyright 2016-present Datadog, Inc.

package e2etests

import "fmt"

const (
	remoteInstallerPath   = "C:\\Users\\Administrator\\Desktop"
	installerName         = "injector_IIS_installer.msi"
	defaultModuleName     = "DDIISInjectorModule"
	defaultBinPath        = "C:\\Program Files\\Datadog\\Datadog RUM\\injector_IIS.dll"
	exampleConfigPath     = "C:\\ProgramData\\Datadog RUM\\example-config.json"
	defaultConfigDir      = "C:\\ProgramData\\Datadog RUM\\"
	defaultConfigName     = "rum-config.json"
	defaultConfigLocation = "Registry::"
	defaultConfigHive     = "HKEY_LOCAL_MACHINE"
	defaultRegistryTree   = "Software"
	defaultCompanyName    = "Datadog"
	defaultProductName    = "Datadog Rum"
)

var expectedBinAccess = []basicFileAccess{
	{
		FileSystemRights:  "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "NT AUTHORITY\\SYSTEM",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
	{
		FileSystemRights:  "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "BUILTIN\\Administrators",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
	{
		FileSystemRights:  "ReadAndExecute, Synchronize",
		AccessControlType: "Allow",
		IdentityReference: "BUILTIN\\Users",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
	{
		FileSystemRights:  "ReadAndExecute, Synchronize",
		AccessControlType: "Allow",
		IdentityReference: "APPLICATION PACKAGE AUTHORITY\\ALL APPLICATION PACKAGES",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
	{
		FileSystemRights:  "ReadAndExecute, Synchronize",
		AccessControlType: "Allow",
		IdentityReference: "APPLICATION PACKAGE AUTHORITY\\ALL RESTRICTED APPLICATION PACKAGES",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
}

var expectedConfigAccess = []basicFileAccess{
	{
		FileSystemRights:  "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "NT AUTHORITY\\SYSTEM",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
	{
		FileSystemRights:  "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "BUILTIN\\Administrators",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
	{
		FileSystemRights:  "ReadAndExecute, Synchronize",
		AccessControlType: "Allow",
		IdentityReference: "BUILTIN\\Users",
		IsInherited:       "True",
		InheritanceFlags:  "None",
		PropagationFlags:  "None",
	},
}

var expectedRegKeyAccess = []basicFileAccess{
	{
		RegistryRights:    "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "BUILTIN\\Administrators",
		IsInherited:       "True",
		InheritanceFlags:  "ContainerInherit",
		PropagationFlags:  "None",
	},
	{
		RegistryRights:    "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "NT AUTHORITY\\SYSTEM",
		IsInherited:       "True",
		InheritanceFlags:  "ContainerInherit",
		PropagationFlags:  "None",
	},
	{
		RegistryRights:    "FullControl",
		AccessControlType: "Allow",
		IdentityReference: "CREATOR OWNER",
		IsInherited:       "True",
		InheritanceFlags:  "ContainerInherit",
		PropagationFlags:  "InheritOnly",
	},
}

func getConfigRegistryPath() string {
	return fmt.Sprintf("Registry::%s\\%s\\%s\\%s", defaultConfigHive, defaultRegistryTree, defaultCompanyName, defaultProductName)
}
