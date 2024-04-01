package pages;


import helperMethods.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver webDriver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;
    public FrameMethods frameMethods;
    public SelectMethod selectMethod;
    public WindowMethod windowMethod;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        elementMethods = new ElementMethods(webDriver);
        alertMethods = new AlertMethods(webDriver);
        frameMethods = new FrameMethods(webDriver);
        selectMethod = new SelectMethod(webDriver);
        windowMethod = new WindowMethod(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
