package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CallsReportPage {

    public void mainPage(){
        step("Переход на страницу журнала отчетов", ()-> open("/400090631/400146918/400146923/widgets/14588/journals/calls"));
        step("Проверка загрузки элементов на странице", ()->{
            $(".dct-header__title").shouldHave(text("Журнал звонков"));
            $(".dct-table__cell-source_medium").shouldBe(enabled);
        });

    }

    public void filterBySourceMedium(){
        String filterValue = "(direct) / (none)";
        step("Клик по кнопке Фильтры",
                ()-> $$(".no-livequery").findBy(text("Фильтры")).click());
        step("Выбор атрибута фильтра",
                ()-> $$(".dct-checkbox__container").findBy(text("Источник/канал")).click());
        step("Ввод условия фильтра: " + filterValue,
                ()-> $(".mgo-chip-input").setValue(filterValue).pressEnter());
        step("Нажатие на кнопку Применить",
                ()-> $$(".no-livequery").findBy(text("Применить")).click());
        step("Поиск первой строки со значением равным " +filterValue,
                ()->$(".dct-table__cell-source_medium").shouldHave(text(filterValue)));
    }
}
