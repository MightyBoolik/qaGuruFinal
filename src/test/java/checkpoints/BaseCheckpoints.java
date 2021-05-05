package checkpoints;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseCheckpoints {

    @Step("Проверка корректного открытия страницы отчетов")
    public void checkFirstRowInGridAndTitle(String name){
        $(".dct-header__title").shouldHave(text(name));
        $(".dct-table__cell-source_medium").shouldBe(enabled);
    }

    @Step("Проверка закрытия модального окна заявки на подключение")
    public void checkDisappearRequestModal(){
        $(".dct-modal__header").shouldBe(disappear);
    }

    @Step("Проверка закрытия модального окна смены тарифа")
    public void checkDisappearChangePlanModal(){
        $(".dct-modal__container.change-tariff__container").shouldBe(disappear);
    }

    @Step("Проверка открытия модального окна помощи в настройках")
    public void checkOpenedHelpWindow(){
        switchTo().frame($(By.xpath("//iframe[@title='YouTube video player']")));
        $(".ytp-large-play-button").isEnabled();
        switchTo().defaultContent();
        $$(".onboarding-tutorial__btn")
                .findBy(text("Завершить"))
                .click();
    }

    @Step("Проверка открытия страницы Дашборды")
    public void checkDashboardLaunch(){
        $$(".column-chart__label-name")
                .shouldHave(texts("Показы","Сеансы","Обращения", "Лиды", "Сделки", "Закрытые сделки"));

        $$(".information-block__title")
                .shouldHave(texts("Конверсия сеансов в лиды", "Средняя стоимость лида",
                        "Конверсия лидов в сделки", "Среднее число обращений в день"));
    }

    @Step("Проверка наличия строки в гриде со указанным значением фильтра")
    public void checkRowWithTags(String filterValue){
        $(".dct-table__cell-source_medium").shouldHave(text(filterValue));
    }
}