package tests;

import helperMethods.ElementMethods;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertWindowFramePage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToAlertPage();

        elementMethods.scrollElemByPixel(0, 450);
        AlertPage alertPage = new AlertPage(getWebDriver());

//1 button normal
        alertPage.acceptAlert();
//2 5sec wait button
        alertPage.alertTimerComplex();
//4 prompt and text button and validates
        alertPage.promptSimple("sarmale");
//3 confirm decline button and validates
        alertPage.cancelAlert();
    }
}

