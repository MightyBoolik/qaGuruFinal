package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.TestBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.ConfigHelper.getWebVideoStorage;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class AttachmentsHelper {

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] attachPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachVideo(String SessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getWebVideoUrl(SessionId)
                + "' type='video/mp4'></video></body></html>";
    }

    public static String getWebVideoUrl(String SessionId) {
        try {
            return new URL(getWebVideoStorage() + SessionId + ".mp4") + "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }

}