package tests;

import org.testng.annotations.Test;
import pages.AlertWindowFramePage;
import pages.FramePage;
import pages.HomePage;
import sharedData.Hooks;
import sharedData.SharedData;

public class FramesTest extends Hooks {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToFramePage();

        FramePage framePage = new FramePage(getWebDriver());
        framePage.dealWithIFrame();
    }
}