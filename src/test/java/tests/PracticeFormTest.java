package tests;

import object.data.PracticeFormObject;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import property.utility.PropertyUtility;
import shared.data.SharedData;


public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        HomePage homePage = new HomePage(getWebDriver());
        FormsPage formsPage = new FormsPage(getWebDriver());
        PracticeFormPage practiceFormPage = new PracticeFormPage(getWebDriver());
        PropertyUtility propertyUtility = new PropertyUtility("practiceFormData");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        homePage.navigateToFormsPage();
        formsPage.navigateToPracticeForm();
//fill entire form
        practiceFormPage.fillEntireForm(practiceFormObject);
//assert validari
        practiceFormPage.validatePracticeForm(practiceFormObject);
    }
}
