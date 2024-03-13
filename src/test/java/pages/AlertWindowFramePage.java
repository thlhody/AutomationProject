package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertWindowFramePage extends BasePage {
    public AlertWindowFramePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsElem;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesElem;

    public void navigateToAlertPage (){
        elementMethods.clickElem(alertsElem);
    }

    public void navigateToFramePage (){
        elementMethods.clickElem(framesElem);
    }
}
