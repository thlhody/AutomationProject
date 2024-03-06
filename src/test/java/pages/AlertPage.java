package pages;

import helperMethods.ElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BasePage{
    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "alertButton")
    private WebElement alertSimple;

    @FindBy(id = "timerAlertButton")
    WebElement alertTimerComplex;

    @FindBy(id = "promtButton")
    WebElement promptSimple;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "promptResult")
    WebElement promptResult;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public void acceptAlert (){
        elementMethods.clickElem(alertSimple);
        alertMethods.acceptAlert();
    }
    public void cancelAlert (){
        elementMethods.clickElem(confirmButton);
        alertMethods.dismissAlert();
        elementMethods.validateElementText(confirmResult, "You selected Cancel");
    }

    public void alertTimerComplex(){
        elementMethods.clickElemForce(alertTimerComplex);
        alertMethods.acceptAlert();
    }
    public void promptSimple(String text){
        elementMethods.clickElem(promptSimple);
        alertMethods.fillAlert(text);
        elementMethods.validateElementText(promptResult,"You entered "+ text);
    }

}
