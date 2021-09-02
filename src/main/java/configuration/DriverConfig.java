package configuration;

import java.nio.file.Paths;

public final class DriverConfig {

    public static String getDriverBinary() {
        String osName = System.getProperty("os.name").toLowerCase();
        String path;
        if (osName.contains("windows")) {
            path = Paths.get("src/test/drivers/chromedriver_win.exe").toAbsolutePath().toString();
        } else if (osName.contains("mac")) {
            path = Paths.get("src/test/drivers/chromedriver_mac").toAbsolutePath().toString();
        } else if (osName.contains("linux")) {
            path = Paths.get("src/test/drivers/chromedriver_linux").toAbsolutePath().toString();
        } else {
            throw new RuntimeException("Oops, looks like your OS not supported!");
        }
        return path;
    }

}
