package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {
    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementPage();
        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        elementsPage.navigateToWebTablePage();

        String firstNameValue="Tudor";
        String lastNameValue="Hody";
        String emailValue="thlhody@gmail.com";
        String ageValue="34";
        String salaryValue="1000";
        String departamentValue="IT";

        String firstNameModifyValue="Andrei";
        String lastNameModifyValue="Vasile";
        String emailModifyValue="yoyoyy@gmail.com";
        String ageModifyValue="22";
        String salaryModifyValue="4000";
        String departamentModifyValue="Grafica";

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(firstNameValue,lastNameValue,emailValue,ageValue,salaryValue,departamentValue);
        webTablePage.editEntry(firstNameModifyValue,lastNameModifyValue,emailModifyValue,ageModifyValue,salaryModifyValue,departamentModifyValue);
        webTablePage.deleteEntry();
    }
}
