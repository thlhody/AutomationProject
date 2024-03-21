package shared.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class SharedData {
    private WebDriver webDriver;

    @BeforeMethod
    public void prepareDriver(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com");
        //wait implicit
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @AfterMethod
    public void clearData(){
        webDriver.quit();
    }
}
