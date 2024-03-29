package tests;

import org.testng.annotations.Test;
import pages.AlertWindowFramePage;
import pages.BrowserWindowsPage;
import pages.HomePage;
import shared.data.SharedData;


public class WindowTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(getWebDriver());

        homePage.navigateToAlertFrameWindowPage();
        alertWindowFramePage.navigateToBrowserWindowPage();
//tab
        browserWindowsPage.interactWithNewTab();
//window
        browserWindowsPage.intercatWithNewWindow();
//window message
        browserWindowsPage.interactWithNewWindowMsgButton();
    }
}
