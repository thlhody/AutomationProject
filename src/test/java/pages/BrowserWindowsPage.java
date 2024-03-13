package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends HomePage{
    public BrowserWindowsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMsgButton;

    public void interactWithNewTab (){

        elementMethods.clickElem(newTabButton);
        windowMethod.switchSpecificTabWindow(1);//sample window
        windowMethod.closeCurrentTabWindow();
        windowMethod.switchSpecificTabWindow(0);//browser window
    }
    public void intercatWithNewWindow (){

        elementMethods.clickElem(newWindowButton);
        windowMethod.switchSpecificTabWindow(1);//sample window
        windowMethod.closeCurrentTabWindow();
        windowMethod.switchSpecificTabWindow(0);//browser window
    }
    public void interactWithNewWindowMsgButton(){

        elementMethods.clickElem(newWindowMsgButton);
        windowMethod.switchSpecificTabWindow(1);//sample window
        windowMethod.closeCurrentTabWindow();
        windowMethod.switchSpecificTabWindow(0);//browser window
    }
}

