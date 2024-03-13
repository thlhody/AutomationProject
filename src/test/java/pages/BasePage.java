package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.SelectMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public ElementMethods elementMethods;
    public WebDriver webDriver;
    public AlertMethods alertMethods;
    public FrameMethods frameMethods;

    public SelectMethod selectMethod;


    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        elementMethods = new ElementMethods(webDriver);
        alertMethods = new AlertMethods(webDriver);
        frameMethods = new FrameMethods(webDriver);
        selectMethod = new SelectMethod(webDriver);
        PageFactory.initElements(webDriver,this);


    }
}
