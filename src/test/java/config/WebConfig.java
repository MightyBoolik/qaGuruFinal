package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config_web.properties")
public interface WebConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("url")
    String getUrl();

    @Key("user")
    String user();

    @Key("password")
    String password();

    @Key("auth_token")
    String getAuthToken();

    @Key("issa")
    String getIssa();
}