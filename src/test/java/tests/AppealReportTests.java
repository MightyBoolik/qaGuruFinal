package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AppealReportPage;
import ru.allure.JiraIssue;
import ru.allure.JiraIssues;

public class AppealReportTests extends TestBase {
    AppealReportPage appealPage = new AppealReportPage();

    @Test
    @AllureId("1979")
    @JiraIssues(@JiraIssue("QC3-29"))
    @DisplayName("Переход в журнал обращений")
    @Description("Переход на страницу журнала обращений")
    void openReport(){
        appealPage.mainPage();
    }
}
