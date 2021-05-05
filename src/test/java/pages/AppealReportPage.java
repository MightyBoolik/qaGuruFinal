package pages;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AppealReportPage {

    public void openAppealReportMainPage() {
        step("Переход на страницу журнала отчетов", () ->
                open("/400090631/400146918/400146923/widgets/14588/journals/appeal"));
    }
}
