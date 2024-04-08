package pages;

import loggerUtility.LoggerUtility;
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
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindows;

    public void navigateToAlertPage() {

        elementMethods.clickElem(alertsElem);
        LoggerUtility.infoTest("User Navigate to Alerts Page");
    }

    public void navigateToFramePage() {
        elementMethods.clickElem(framesElem);
        LoggerUtility.infoTest("User Navigate to Frames Page");
    }

    public void navigateToBrowserWindowPage() {
        elementMethods.clickElem(browserWindows);
        LoggerUtility.infoTest("User Navigate to Browser window Page");
    }

}
