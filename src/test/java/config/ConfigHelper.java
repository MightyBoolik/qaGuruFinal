package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getWebUrl() {
        return getWebConfig().getUrl();
    }

    public static String getBrowser(){
        return getWebConfig().getBrowser();
    }

    public static String getWebRemoteDriver() {
        return String.format(System.getProperty("remote.driver"),
                getWebConfig().user(),
                getWebConfig().password());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("remote.driver") != null;
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    public static String getWebVideoStorage(){
        return System.getProperty("video.storage");
        }

    private static WebConfig getWebConfig(){
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}
