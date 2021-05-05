package tests.ui;

import checkpoints.BaseCheckpoints;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AppealReportPage;
import report.JiraIssue;
import tests.TestBase;

@Feature("Демо-кабинет. Журнал обращений")
public class AppealReportTests extends TestBase {
    AppealReportPage appealPage = new AppealReportPage();
    BaseCheckpoints baseCheck = new BaseCheckpoints();



    @Test
    @JiraIssue("QC3-31")
    @Story("Переход в журнал обращений")
    @DisplayName("Переход на страницу журнала обращений")
    void openReport(){
        appealPage.openAppealReportMainPage();
        baseCheck.checkFirstRowInGridAndTitle("Журнал обращений");
    }
}
