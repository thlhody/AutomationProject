package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementFileElement;

    public void navigateToAlertFrameWindowPage(){
        //elementMethods.clickElem(acceptCookies);
        elementMethods.clickElem(alertWindowFrameElem);
    }
    public void navigateToFormsPage(){
        elementMethods.clickElem(practiceFormElement);
    }
    public void navigateToElementPage(){
        elementMethods.clickElem(elementFileElement);
    }
}


