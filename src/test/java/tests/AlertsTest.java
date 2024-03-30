package tests;

import object.data.AlertObject;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertWindowFramePage;
import pages.HomePage;
import property.utility.PropertyUtility;
import shared.data.SharedData;

public class AlertsTest extends SharedData {

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
        //tema
        alertPage.promptSimple(alertObject.getInputText());
//3 confirm decline button and validates
        alertPage.cancelAlert();
    }
}

