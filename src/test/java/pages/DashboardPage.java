package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class DashboardPage {

    public void openPage(){
        step("Переход на страницу дашборда", ()->{
            $$(".item-product__name")
                    .findBy(text("Дашборды"))
                    .click();
        });
    }
}
