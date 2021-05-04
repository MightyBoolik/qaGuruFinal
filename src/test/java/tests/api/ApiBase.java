package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static config.ConfigHelper.getWebUrl;

public class ApiBase {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = getWebUrl();
        ;
    }
}

