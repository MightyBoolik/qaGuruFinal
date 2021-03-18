package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CallsReportPage;


@DisplayName("Демо-кабинет. Журнал звонков")
public class CallsReportTests extends TestBase{
    CallsReportPage callsPage = new CallsReportPage();

    @Test
    @DisplayName("Переход в журнал звонков")
    @Description("Переход на страницу журнала звонков")
    void openReport(){
        callsPage.mainPage();
    }

    @Test
    @DisplayName("Фильтр отчета")
    @Description("Проверка работы фильтра отчета по атрибут источник/канал")
    void filterBySourceMedium(){
        callsPage.mainPage();
        callsPage.filterBySourceMedium();
    }
}
