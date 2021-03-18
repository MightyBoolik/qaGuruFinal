package pages;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainCaaPage {

    public void openPage() {
        step("Открытие демо-кабинета", ()->open("/ics/demo"));
        step("Меню продуктов загрузилось",()->{
            $(".internal-products").shouldBe(visible);
        });
        step("Блок сквозной аналитики загрузился", ()->{
            $(".dct-header__title").shouldHave(text("Сквозная аналитика"));
            $(".chart-header").shouldBe(visible);
        });
    }

    public void makeRequest() {
        step("Нажать на кнопку Подключить",
                ()-> $("button").shouldHave(text("Подключить")).click());
        step("Заполнение персональных данных",
                ()-> {
            $("input[placeholder='Ваше имя']").setValue("Иван");
            $("input[placeholder='Yourmail@email.ru']").setValue("iv@nov.ru");
            $("input[formcontrolname='phone']").setValue("9999999999");
        });
        step("Отправить заявку на подключение", ()->
                $$(".dct-modal__footer button").findBy(text("Подключить")).click());
        //sleep(1000);
       //проверка, что окно закрылось
        //$(".dct-dialog__close").click();
        step("Проверка закрытия модального окна", ()->
                $(".dct-modal__header").shouldBe(disappear));
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

    public void helpAccess(){
        step("Вызов модального окна помощи настроек", ()->{
            $(".icon-button").click();
            $(".cca-page__menu-item__name")
                    .shouldHave(text("Помощь в настройке"))
                    .click();
            $(".dct-modal.onboarding-tutorial").shouldHave(visible, enabled);
        });
        step("Проверка в модальном окне",()->{
            switchTo().frame($(By.xpath("//iframe[@title='YouTube video player']")));
            $(".ytp-large-play-button").isEnabled();
            switchTo().defaultContent();
            $$(".onboarding-tutorial__btn")
                    .findBy(text("Завершить"))
                    .click();
        });
    }

    public void dashboardPage(){
        step("Переход на страницу дашборда", ()->{
            $$(".item-product__name")
                    .findBy(text("Дашборды"))
                    .click();
            $$(".column-chart__label-name")
                    .shouldHave(texts("Показы","Сеансы","Обращения", "Лиды", "Сделки", "Закрытые сделки"), 2000);

            $$(".information-block__title")
                    .shouldHave(texts("Конверсия сеансов в лиды", "Средняя стоимость лида",
                            "Конверсия лидов в сделки", "Среднее число обращений в день"
                            ));
        });
    }
}