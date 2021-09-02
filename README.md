How to launch test:
1. Start appium server
2. In command line execute mvn -DdeviceName=${youDeviceName} test

${youDeviceName} -> virual or real device, use "adb devices" command to get list of decives
e.g. mvn -DdeviceName=emulator-5554 test

OR
Open project in IDE and click start button next to test
