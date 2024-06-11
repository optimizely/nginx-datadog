if not exist c:\mnt\ goto nomntdir

:: Windows runners get re-used between jobs, so we must make sure to run our builds in a temporary location
mkdir \build
cd \build || exit /b 2
xcopy /e/s/h/q c:\mnt\*.* || exit /b 3

:: Build the injection library (also builds the rust shared library)
c:\devtools\vstudio\MSBuild\Current\Bin\MSBuild.exe injector_IIS\injector_IIS.vcxproj^
 /m:4 /p:Configuration=%BUILD_CONFIGURATION% /p:Platform=%ARCH% || exit /b 4

:: Build the injection library unit tests
:: - TestDir must be set to wherever the injector_IIS\test directory will be located on the system where the tests will be run
::   in order for the unit tests to be able to find the test assets (ie config files) at runtime
c:\devtools\vstudio\MSBuild\Current\Bin\MSBuild.exe -restore injector_IIS\test\unit_tests.vcxproj^
 /m:4 /p:Configuration=%BUILD_CONFIGURATION% /p:Platform=%ARCH% /p:RestorePackagesConfig=true /p:SolutionDir=\build\injector_IIS\ /p:TestDir=%TEST_DIR% || exit /b 5

:: Sign the injection library DLL
dd-wcs sign injector_IIS\%ARCH%\%BUILD_CONFIGURATION%\injector_IIS.dll || exit /b 6

:: Build the installer
::  - BuildProjectReferences=false ensures that we don't rebuild the injection lib. Doing so would overwrite the dll
::    which we just signed, and we want to make sure to package the signed version.
::  - PostBuildEvent= overwrites the post build event which copies the installer to the e2e directory for testing (this action
::    doesn't work in the build container & isn't necessary for CI builds, which this script is intended for, so we can just skip it)
 c:\devtools\vstudio\MSBuild\Current\Bin\MSBuild.exe injector_IIS\injector_IIS_installer\injector_IIS_installer.wixproj^
  /m:4 /p:Configuration=%BUILD_CONFIGURATION% /p:Platform=%ARCH%  /p:PostBuildEvent= /p:BuildProjectReferences=false || exit /b 7

:: Sign the installer
dd-wcs sign injector_IIS\injector_IIS_installer\bin\%ARCH%\%BUILD_CONFIGURATION%\en-us\injector_IIS_installer.msi || exit /b 8

:: Copy output files to the output directory
:: We use BUILD_OUTDIR as the env var instead of OUTDIR so as not to confuse VS
if not exist %BUILD_OUTDIR% mkdir %BUILD_OUTDIR% || exit /b 9

copy /y injector_IIS\injector_IIS_installer\bin\%ARCH%\%BUILD_CONFIGURATION%\en-us\injector_IIS_installer.msi %BUILD_OUTDIR%
copy /y injector_IIS\test\%ARCH%\%BUILD_CONFIGURATION%\unit_tests.exe %BUILD_OUTDIR%

goto :EOF

:nomntdir
@echo directory not mounted, parameters incorrect
exit /b 1
goto :EOF