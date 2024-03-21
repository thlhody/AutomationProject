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
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToBrowserWindowPage();
//tab
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(getWebDriver());
        browserWindowsPage.interactWithNewTab();
//window
        browserWindowsPage.intercatWithNewWindow();
//window message
        browserWindowsPage.interactWithNewWindowMsgButton();
    }
}
