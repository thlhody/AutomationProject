package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertSimple;
    @FindBy(id = "timerAlertButton")
    private WebElement alertTimerComplex;
    @FindBy(id = "promtButton")
    private WebElement promptSimple;
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    @FindBy(id = "promptResult")
    private WebElement promptResult;
    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    public void acceptAlert() {

        elementMethods.clickElem(alertSimple);
        LoggerUtility.infoTest("User Click Alert Simple");
        alertMethods.acceptAlert();
        LoggerUtility.infoTest("User Accept Alert");
    }

    public void cancelAlert() {

        elementMethods.clickElem(confirmButton);
        LoggerUtility.infoTest("User clicks Alert Ok/Cancel");
        alertMethods.dismissAlert();
        LoggerUtility.infoTest("User Alert Cancel Selected");
        elementMethods.validateElementText(confirmResult, "You selected Cancel");
        LoggerUtility.infoTest("User Validates Alert Cancel");
    }

    public void alertTimerComplex() {

        elementMethods.clickElemForce(alertTimerComplex);
        LoggerUtility.infoTest("User clicks Alert Timer");
        alertMethods.acceptAlert();
        LoggerUtility.infoTest("User Accept Alert");
    }

    public void promptSimple(String text) {

        elementMethods.clickElem(promptSimple);
        LoggerUtility.infoTest("User clicks Alert Prompt");
        alertMethods.fillAlert(text);
        LoggerUtility.infoTest("User Entered Alert: "+text);
        elementMethods.validateElementText(promptResult, "You entered " + text);
        LoggerUtility.infoTest("User Validates Prompt Alert: "+text);
    }
}
