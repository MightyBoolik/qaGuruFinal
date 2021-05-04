package tests.ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DashBoardPage;
import pages.MainCaaPage;
import ru.allure.JiraIssue;
import ru.allure.JiraIssues;
import tests.TestBase;

@DisplayName("Демо-кабинет. Главная страница")
public class CaaTests extends TestBase {
    MainCaaPage caaPage = new MainCaaPage();
    DashBoardPage dashBoardPage = new DashBoardPage();


    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Заявка на подключение")
    @Description("Тест заявки на подключение")
    void makeAddRequestTest(){
        caaPage.makeRequest();
    }

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Заявка на смену тарифа")
    @Description("Тест заявки на смену тарифа")
    void hitChangePlanTest(){
        caaPage.hitChangePlan();
    }

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Помощь в настройке")
    @Description("Тест помощи в настройке")
    void helpAccessTest(){
        caaPage.helpAccess();
    }

    @Test
    @JiraIssues(@JiraIssue("QC3-31"))
    @DisplayName("Переход в дашборды")
    @Description("Тест перехода в дашборды")
    void goToDashboard(){
        dashBoardPage.dashboardMainPage();
    }
    
}

//для api https://lk.mango-office.ru/ics/api/400146923/calltracking/widgets/14588
//