package tests.api;

import api.Auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.allure.JiraIssue;
import ru.allure.JiraIssues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static templates.ReportTemplate.filters;


public class ApiTests extends ApiBase {
    String widgetName = "Демо доступ";


    @Test
    @JiraIssue("QC3-29")
    @DisplayName("Настройки виджета")
    void widgetSettings(){

        Map<String, String> cookies = new Auth().login();
        Response response =
        given()
                .cookies(cookies)
                .filter(filters().customTemplates())
                .when()
                .get("/ics/api/400146923/calltracking/widgets/14588")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().response();

        Integer act_wid = response.jsonPath().get("widget_id") ;

        assertEquals(14588, act_wid, "номера виджетов не совпадают");
        assertEquals(widgetName, response.jsonPath().get("name"), "название виджетов не совпадают");
    }

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Превью продукта")
    void ctPreviews(){
        Map<String, String> cookies = new Auth().login();
        Response response =
                given()
                        .cookies(cookies)
                        .filter(filters().customTemplates())
                        .when()
                        .get("/ics/api/400146923/calltracking/previews")
                        .then()
                        .contentType(ContentType.JSON)
                        .statusCode(200)
                        .extract().response();

        assertEquals(widgetName, response.jsonPath().get("name"), "название виджетов не совпадают");
    }
}