package teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TemaPrincipalTest {
    public WebDriver webDriver;

    @Test
    public void metodaTestComplet() {

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com");
        WebElement acceptCookiesELement = webDriver.findElement(By.className("fc-button-label"));
        acceptCookiesELement.click();

        TemaWebTabelTest webTabelTest = new TemaWebTabelTest();
        webTabelTest.metodaPrincipala(webDriver);

        webDriver.navigate().back();
        webDriver.navigate().back();
        TemaPracticeFormTest practiceFormTest = new TemaPracticeFormTest();
        practiceFormTest.metodaPrincipala(webDriver);
        webDriver.quit();


    }
}
