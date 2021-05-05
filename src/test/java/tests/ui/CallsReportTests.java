package tests.ui;

import checkpoints.BaseCheckpoints;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CallsReportPage;
import report.JiraIssue;
import report.JiraIssues;
import tests.TestBase;



@Feature("Демо-кабинет. Журнал звонков")
public class CallsReportTests extends TestBase {
    CallsReportPage callsPage = new CallsReportPage();
    BaseCheckpoints baseChecks = new BaseCheckpoints();

    @Test
    @JiraIssue("QC3-31")
    @Story("Переход в журнал звонков")
    @DisplayName("Переход на страницу журнала звонков")
    void openReport(){
        callsPage.openCallsReportPage();
        baseChecks.checkFirstRowInGridAndTitle("Журнал звонков");
    }

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @Story("Фильтр отчета")
    @DisplayName("Проверка работы фильтра отчета по атрибут источник/канал")
    void filterBySourceMedium(){
        String filterValue = "(direct) / (none)";
        callsPage.openCallsReportPage();
        callsPage.filterReportBySourceMediumTags(filterValue);
        baseChecks.checkRowWithTags(filterValue);
    }
}
