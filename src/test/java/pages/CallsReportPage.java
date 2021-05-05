package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CallsReportPage {

    public void openCallsReportPage(){
        step("Переход на страницу журнала отчетов", ()->
                open("/400090631/400146918/400146923/widgets/14588/journals/calls"));
    }

    public void filterReportBySourceMediumTags(String filterValue){
        step("Клик по кнопке Фильтры",
                ()-> $$(".no-livequery").findBy(text("Фильтры")).click());
        step("Выбор атрибута фильтра",
                ()-> $$(".dct-checkbox__container").findBy(text("Источник/канал")).click());
        step("Ввод условия фильтра: " + filterValue,
                ()-> $(".mgo-chip-input").setValue(filterValue).pressEnter());
        step("Нажатие на кнопку Применить",
                ()-> $$(".no-livequery").findBy(text("Применить")).click());
    }
}
