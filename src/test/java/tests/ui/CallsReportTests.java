package tests.ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CallsReportPage;
import ru.allure.JiraIssue;
import ru.allure.JiraIssues;
import tests.TestBase;


@DisplayName("Демо-кабинет. Журнал звонков")
public class CallsReportTests extends TestBase {
    CallsReportPage callsPage = new CallsReportPage();

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Переход в журнал звонков")
    @Description("Переход на страницу журнала звонков")
    void openReport(){
        callsPage.mainPage();
    }

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Фильтр отчета")
    @Description("Проверка работы фильтра отчета по атрибут источник/канал")
    void filterBySourceMedium(){
        callsPage.mainPage();
        callsPage.filterBySourceMedium();
    }
}
