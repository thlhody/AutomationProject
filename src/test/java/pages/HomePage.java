package pages;

import helperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    //@FindBy(className = "fc-button-label")
    //private WebElement acceptCookies;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertWindowFrameElem;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement practiceFormElement;




    public void navigateToAlertFrameWindowPage(){
        //elementMethods.clickElem(acceptCookies);
        elementMethods.clickElem(alertWindowFrameElem);
    }
    public void navigateToFormsPage(){
        elementMethods.clickElem(practiceFormElement);

    }


}


