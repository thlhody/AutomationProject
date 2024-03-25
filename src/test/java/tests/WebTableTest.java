package tests;

import object.data.WebTableObject;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import property.utility.PropertyUtility;
import shared.data.SharedData;

public class WebTableTest extends SharedData {
    @Test
    public void metodaTest() {

        PropertyUtility propertyUtility = new PropertyUtility("webTableData");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementPage();
        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        elementsPage.navigateToWebTablePage();

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(webTableObject);
        webTableObject.setFirstNameValue("Bogdan");
        webTableObject.setLastNameValue("Georgel");
        webTableObject.setDepartamentValue("IT Serios");
        webTablePage.editEntry(webTableObject);
        webTablePage.deleteEntry();

    }
}
