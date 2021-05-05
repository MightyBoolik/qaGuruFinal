package tests.ui;

import checkpoints.BaseCheckpoints;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.MainCaaPage;
import report.JiraIssue;
import tests.TestBase;

@Feature("Демо-кабинет. Страница СА")
public class CaaTests extends TestBase {
    MainCaaPage caaPage = new MainCaaPage();
    DashboardPage dashBoardPage = new DashboardPage();
    BaseCheckpoints baseCheck = new BaseCheckpoints();



    @Test
    @JiraIssue("QC3-31")
    @Story("Заявка на подключение")
    @DisplayName("Тест заявки на подключение")
    void makeAddRequestTest(){
        caaPage.makeNewRequest();
        baseCheck.checkDisappearRequestModal();
    }

    @Test
    @JiraIssue("QC3-31")
    @Story("Заявка на смену тарифа")
    @DisplayName("Тест заявки на смену тарифа")
    void hitChangePlanTest(){
        caaPage.hitChangePlan();
        baseCheck.checkDisappearChangePlanModal();
    }

    @Test
    @JiraIssue("QC3-31")
    @Story("Помощь в настройке")
    @DisplayName("Тест помощи в настройке")
    void helpAccessTest(){
        caaPage.clickHelpAccess();
        baseCheck.checkOpenedHelpWindow();
    }

    @Test
    @JiraIssue("QC3-31")
    @Story("Переход в дашборды")
    @DisplayName("Тест перехода в дашборды")
    void goToDashboard(){
        dashBoardPage.openPage();
        baseCheck.checkDashboardLaunch();
    }
}
