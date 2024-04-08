package tests;

import objectData.WebTableObject;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

public class WebTableTest extends Hooks {
    @Test
    public void metodaTest() {

        PropertyUtility propertyUtility = new PropertyUtility("webTableData");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());
        HomePage homePage = new HomePage(getWebDriver());
        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        WebTablePage webTablePage = new WebTablePage(getWebDriver());

        homePage.navigateToElementPage();
        elementsPage.navigateToWebTablePage();

        webTablePage.addNewEntry(webTableObject);
        webTableObject.setFirstNameValue("Bogdan");
        webTableObject.setLastNameValue("Georgel");
        webTableObject.setDepartamentValue("IT Serios");
        webTablePage.editEntry(webTableObject);
        webTablePage.deleteEntry();
    }
}
