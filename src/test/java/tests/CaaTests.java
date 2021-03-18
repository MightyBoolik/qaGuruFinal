package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DashBoardPage;
import pages.MainCaaPage;

@DisplayName("Демо-кабинет. Главная страница")
public class CaaTests extends TestBase{
    MainCaaPage caaPage = new MainCaaPage();
    DashBoardPage dashBoardPage = new DashBoardPage();


    @Test
    @DisplayName("Заявка на подключение")
    @Description("Тест заявки на подключение")
    void makeAddRequestTest(){
        caaPage.makeRequest();
    }

    @Test
    @DisplayName("Заявка на смену тарифа")
    @Description("Тест заявки на смену тарифа")
    void hitChangePlanTest(){
        caaPage.hitChangePlan();
    }

    @Test
    @DisplayName("Помощь в настройке")
    @Description("Тест помощи в настройке")
    void helpAccessTest(){
        caaPage.helpAccess();
    }

    @Test
    @DisplayName("Переход в дашборды")
    @Description("Тест перехода в дашборды")
    void goToDashboard(){
        dashBoardPage.dashboardMainPage();
    }
    
}
