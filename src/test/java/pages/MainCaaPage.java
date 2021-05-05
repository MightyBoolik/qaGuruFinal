package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainCaaPage {

    public void openCaa() {
        step("Открытие демо-кабинета", ()->open("/ics/demo"));
        step("Меню продуктов загрузилось",()->{
            $(".internal-products").shouldBe(visible);
        });
        step("Блок сквозной аналитики загрузился", ()->{
            $(".dct-header__title").shouldHave(text("Сквозная аналитика"));
            $(".chart-header").shouldBe(visible);
        });
    }

    public void makeNewRequest() {
        step("Нажать на кнопку Подключить",
                ()-> $("button").shouldHave(text("Подключить")).click());
        step("Заполнение персональных данных", ()-> {
            $("input[placeholder='Ваше имя']").setValue("Иван");
            $("input[placeholder='Yourmail@email.ru']").setValue("iv@nov.ru");
            $("input[formcontrolname='phone']").setValue("9999999999");
        });
        step("Отправить заявку на подключение", ()->
                $$(".dct-modal__footer button").findBy(text("Подключить")).click());
    }

    public void hitChangePlan() {
        step("Нажать на кнопку смены тарифа", () -> {
            $(".dct-tariff__title").click();
            $(".change-tariff__header-title").shouldHave(text("Сменить тариф"));
        });
        step("Заказать смену тарифа", () -> {
            $(".dct-modal__footer button")
                    .shouldHave(text("Заказать смену тарифа"))
                    .click();
            $(".dct-modal__container").shouldHave(text("Спасибо за обращение"));
            $(".dct-dialog__close").click();
        });
        $(".dct-modal__container.change-tariff__container").shouldBe(disappear);
    }

    public void clickHelpAccess(){
        step("Вызов модального окна помощи настроек", ()->{
            $(".icon-button").click();
            $(".cca-page__menu-item__name")
                    .shouldHave(text("Помощь в настройке"))
                    .click();
            $(".dct-modal.onboarding-tutorial").shouldHave(visible, enabled);
        });
    }
}