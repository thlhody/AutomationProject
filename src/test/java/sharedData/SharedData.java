package sharedData;

import org.openqa.selenium.WebDriver;
import sharedData.browser.BrowserFactory;

import java.time.Duration;

public class SharedData {
    private WebDriver webDriver;


    public void prepareDriver() {
        webDriver = new BrowserFactory().getBrowserInstance();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


    public void clearData() {
        webDriver.quit();
    }
}
