package tests;

import helperMethods.ElementMethods;
import helperMethods.SelectMethod;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import java.io.File;
import java.util.*;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
//intram pe pagina practice forms
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormsPage();
        FormsPage formsPage = new FormsPage(getWebDriver());
        formsPage.navigateToPracticeForm();
        PracticeFormPage practiceFormPage =new PracticeFormPage(getWebDriver());

//first name 0.1
        String firstNameValue = "Tudor";
//last name 0.2
        String lastNameValue = "Hody";
//email 1
        String emailValue = "thlhody@gmail.com";
//gender 2.2
        String genderValue = "Male";
//mobile 3
        String mobileValue = "0123456789";
//date of birth 4
        String dobMonthValue = "August";
        String dobYearValue = "1985";
        String dobDayValue = "29";
        //aici cautam toate zilele din luna selectata
        // //div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]
        //sau //div[not(contains(@class,'react-datepicker__day--outside-month')) and  contains(@class,'react-datepicker__day') and contains(@class,'react-datepicker__day--')]
//hobbies 5
        List<String> hobbies = Arrays.asList("Sports", "Music", "Reading");
//picture upload 6
        String filePath = "src/test/resources/uploadpic.jpg";
//address 7
        String addressValue = "test";
//subjects 8
        String subjectValue = "Economics";
//state 9.1
        String stateValue = "Uttar Pradesh";
//city 9.2
        String cityValue = "Lucknow";

//        practiceFormPage.fillFirstName(firstNameValue);
//        practiceFormPage.fillLastName(lastNameValue);
//        practiceFormPage.fillemail(emailValue);
//        practiceFormPage.fillGender(genderValue);
//        practiceFormPage.fillmobile(mobileValue);
//        practiceFormPage.fillDob(dobDayValue,dobMonthValue,dobYearValue);
//        practiceFormPage.pickHobbies(hobbies);
//        practiceFormPage.pictureUpload(filePath);
//        practiceFormPage.fillAddress(addressValue);
//        practiceFormPage.fillSubjects(subjectValue);
//        practiceFormPage.fillState(stateValue);
//        practiceFormPage.fillCity(cityValue);
//        practiceFormPage.submit();


//fill entire form
        practiceFormPage.fillEntireForm(firstNameValue,lastNameValue,emailValue,genderValue,mobileValue,dobDayValue,
                dobMonthValue,dobYearValue,subjectValue,hobbies,filePath,addressValue,cityValue,stateValue);
//assert validari


        //xpath : //table/tbody/tr/td[1] - dintre 2 frati cu aceelasi nume(tr) incep de la 1 primu 2 al doilea ....etc
        //validam tabelul cu valori
        practiceFormPage.validatePracticeForm(firstNameValue,lastNameValue,emailValue,genderValue,mobileValue,dobDayValue,
                dobMonthValue,dobYearValue,subjectValue,hobbies,filePath,addressValue,cityValue,stateValue);



    }
}
