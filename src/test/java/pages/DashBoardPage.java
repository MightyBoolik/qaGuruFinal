package pages;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class DashBoardPage {

    public void dashboardMainPage(){
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
