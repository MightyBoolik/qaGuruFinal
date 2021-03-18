package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AppealReportPage;

public class AppealReportTests {
    AppealReportPage appealPage = new AppealReportPage();

    @Test
    @AllureId("1978")
    @DisplayName("Переход в журнал обращений")
    @Description("Переход на страницу журнала обращений")
    void openReport(){
        appealPage.mainPage();
    }
}
