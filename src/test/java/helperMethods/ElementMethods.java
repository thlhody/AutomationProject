package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {
    private WebDriver webDriver;

    public ElementMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void scrollElemByPixel(Integer paramX, Integer paramY) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(" + paramX + "," + paramY + ")", "");
    }

    public void waitVisibileElem(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElem(WebElement element) {
        waitVisibileElem(element);
        element.click();
    }

    public void clickElemForce(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", element);
    }

    public void validateElementText(WebElement element, String expected) {
        waitVisibileElem(element);
        String actual = element.getText();
        Assert.assertEquals(actual, expected);
    }

    public void validateElementTextSpecial(WebElement element, String text) {
        Assert.assertTrue(element.getText().contains(text));
    }

    public void printElemText(WebElement element) {
        waitVisibileElem(element);
        System.out.println("Textul din frame 1 si dupa 2: " + element.getText());
    }

    public void fillString(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void fillKeys(WebElement element, Keys key) {
        element.sendKeys(key);
    }

    public void refillString(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
