package configuration;

public final class SystemConfig {

    public static String getDeviceName() {
        return System.getProperty("deviceName");
    }
}
