package tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainCaaPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.isVideoOn;
import static config.DriverHelper.configureDriver;
import static config.DriverHelper.getSessionId;
import static helpers.AttachmentsHelper.*;


public class TestBase {

    @BeforeAll
    static void setup() {
        configureDriver();
    }

    @BeforeEach()
    public void beforeEach(){
        MainCaaPage demoPage = new MainCaaPage();
        demoPage.openCaa();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        attachScreenshot("Final screenshot");
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);
        closeWebDriver();
    }
}
