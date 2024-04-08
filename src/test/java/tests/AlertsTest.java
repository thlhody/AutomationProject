package tests;

import objectData.AlertObject;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertWindowFramePage;
import pages.HomePage;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;


public class AlertsTest extends Hooks {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        AlertPage alertPage = new AlertPage(getWebDriver());
        PropertyUtility propertyUtility = new PropertyUtility("alertData");
        AlertObject alertObject = new AlertObject(propertyUtility.getAllData());

        homePage.navigateToAlertFrameWindowPage();
        alertWindowFramePage.navigateToAlertPage();

//1 button normal
        alertPage.acceptAlert();
//2 5sec wait button
        alertPage.alertTimerComplex();
//4 prompt and text button and validates
        alertPage.promptSimple(alertObject.getInputText());
//3 confirm decline button and validates
        alertPage.cancelAlert();
    }
}

