package helpers;

import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static templates.ReportTemplate.filters;

public class CookieHelper {
    public Map<String, String> login() {
        return
                given()
                        .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                        .contentType(ContentType.URLENC)
                        .filter(filters().customTemplates())
                        .when()
                        .get("/ics/demo")
                        .then()
                        .contentType(ContentType.HTML)
                        .log().body()
                        .statusCode(200)
                        .extract().cookies();
    }

//    public Map<String, String> login_man() {
//        //
//
////        Map<String, String> cookies = Map.ofEntries(entry("auth_token", ConfigHelper.getAuthToken()),
////                entry("issa7", ConfigHelper.getIssa()));
////        return cookies;
//
//    }
}
