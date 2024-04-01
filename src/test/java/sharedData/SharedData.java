package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sharedData.browser.BrowserFactory;

import java.time.Duration;

public class SharedData {
    private WebDriver webDriver;

    @BeforeMethod
    public void prepareDriver() {
        webDriver = new BrowserFactory().getBrowserInstance();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @AfterMethod
    public void clearData() {
        webDriver.quit();
    }
}
