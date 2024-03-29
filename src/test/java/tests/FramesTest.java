package tests;

import org.testng.annotations.Test;
import pages.AlertWindowFramePage;
import pages.FramePage;
import pages.HomePage;
import shared.data.SharedData;

public class FramesTest extends SharedData {

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