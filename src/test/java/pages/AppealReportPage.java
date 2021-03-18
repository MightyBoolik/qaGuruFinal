package pages;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AppealReportPage {

    public void mainPage() {
        step("Переход на страницу журнала отчетов", () -> open("/400090631/400146918/400146923/widgets/14588/journals/appeal"));
        step("Проверка загрузки элементов на странице", () -> {
            $(".dct-header__title").shouldHave(text("Журнал обращений"));
            $(".dct-table__cell-source_medium").shouldBe(enabled);
        });
    }
}
