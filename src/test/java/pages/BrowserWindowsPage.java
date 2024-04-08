package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends HomePage {
    public BrowserWindowsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButton;
    @FindBy(id = "windowButton")
    private WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMsgButton;

    public void interactWithNewTab() {

        elementMethods.clickElem(newTabButton);
        LoggerUtility.infoTest("The user clicks on new tab button");
        windowMethod.switchSpecificTabWindow(1);//sample window
        LoggerUtility.infoTest("The user switches to a tab  index 1");
        windowMethod.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes tab");
        windowMethod.switchSpecificTabWindow(0);//browser window
        LoggerUtility.infoTest("The user switches to a tab  index 0");
    }

    public void intercatWithNewWindow() {

        elementMethods.clickElem(newWindowButton);
        LoggerUtility.infoTest("The user clicks on new window button");
        windowMethod.switchSpecificTabWindow(1);//sample window
        LoggerUtility.infoTest("The user switches to a window with index 1");
        windowMethod.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes window");
        windowMethod.switchSpecificTabWindow(0);//browser window
        LoggerUtility.infoTest("The user switches to window with index 0");
    }

    public void interactWithNewWindowMsgButton() {

        elementMethods.clickElem(newWindowMsgButton);
        LoggerUtility.infoTest("The user clicks on new window message button");
        windowMethod.switchSpecificTabWindow(1);//sample window
        LoggerUtility.infoTest("The user switches to a tab/window with index 1");
        windowMethod.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes tab/window");
        windowMethod.switchSpecificTabWindow(0);//browser window
        LoggerUtility.infoTest("The user switches to a tab/window with index 0");
    }
}

