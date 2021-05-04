package tests.ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AppealReportPage;
import ru.allure.JiraIssue;
import tests.TestBase;

public class AppealReportTests extends TestBase {
    AppealReportPage appealPage = new AppealReportPage();

    @Test
    @JiraIssue("QC3-29")
    @DisplayName("Переход в журнал обращений")
    @Description("Переход на страницу журнала обращений")
    void openReport(){
        appealPage.mainPage();
    }
}
