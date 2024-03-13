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
        practiceFormPage.fillFirstName(firstNameValue);
//last name 0.2
        String lastNameValue = "Hody";
        practiceFormPage.fillLastName(lastNameValue);
//email 1
        String emailValue = "thlhody@gmail.com";
        practiceFormPage.fillemail(emailValue);
//gender 2.1
        //radio box trebuie sa mearga dupa input daca nu dupa label
        //WebElement genderElement = webDriver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        //genderElement.click();
//gender 2.2
        String genderValue = "Male";
        practiceFormPage.fillGender(genderValue);
//mobile 3
        String mobileValue = "0123456789";
        practiceFormPage.fillmobile(mobileValue);

//date of birth 4
        String dobMonthValue = "August";
        String dobYearValue = "1985";
        String dobDayValue = "29";
        practiceFormPage.fillDob(dobDayValue,dobMonthValue,dobYearValue);
        //aici cautam toate zilele din luna selectata
        // //div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]
        //sau //div[not(contains(@class,'react-datepicker__day--outside-month')) and  contains(@class,'react-datepicker__day') and contains(@class,'react-datepicker__day--')]
//hobbies 5
        List<String> hobbies = Arrays.asList("Sports", "Music", "Reading");
        practiceFormPage.pickHobbies(hobbies);
//picture upload 6
        String filePath = "src/test/resources/uploadpic.jpg";
        practiceFormPage.pictureUpload(filePath);
//address 7
        String addressValue = "test";
        practiceFormPage.fillAddress(addressValue);
//subjects 8
        String subjectValue = "Economics";
        practiceFormPage.fillSubjects(subjectValue);
//state 9.1
        String stateValue = "Uttar Pradesh";
        practiceFormPage.fillState(stateValue);
//city 9.2
        String cityValue = "Lucknow";
        practiceFormPage.fillCity(cityValue);

//submit
        practiceFormPage.submit();
//assert validari
        //xpath : //table/tbody/tr/td[1] - dintre 2 frati cu aceelasi nume(tr) incep de la 1 primu 2 al doilea ....etc
        //validam tabelul cu valori
//
//        List<WebElement> rowsLabel = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[1]"));
//        List<WebElement> rowsValue = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));
////0 validate first name and last name
//        elementMethods.validateElementText(rowsLabel.get(0), "Student Name");
//        elementMethods.validateElementText(rowsValue.get(0), firstNameValue + " " + lastNameValue);
////1 validate student email
//        elementMethods.validateElementText(rowsLabel.get(1), "Student Email");
//        elementMethods.validateElementText(rowsValue.get(1), emailValue);
////2 validate gender
//        elementMethods.validateElementText(rowsLabel.get(2), "Gender");
//        elementMethods.validateElementText(rowsValue.get(2), genderValue);
////3 validate mobile
//        elementMethods.validateElementText(rowsLabel.get(3), "Mobile");
//        elementMethods.validateElementText(rowsValue.get(3), mobilValue);
////4 validate date of birth
//        String dobDayValueFormatted;
//        if (Integer.parseInt(dobDayValue) >= 1 && Integer.parseInt(dobDayValue) <= 9) {
//            dobDayValueFormatted = "0" + dobDayValue;
//        } else {
//            dobDayValueFormatted = dobDayValue;
//        }
//        elementMethods.validateElementText(rowsLabel.get(4), "Date of Birth");
//        elementMethods.validateElementText(rowsValue.get(4), dobDayValueFormatted + " " + dobMonthElem + "," + dobYearElem);
////5 validate subjects
//        elementMethods.validateElementText(rowsLabel.get(5), "Subjects");
//        elementMethods.validateElementText(rowsValue.get(5), subjectValue);
////6 validate hobbies
//        elementMethods.validateElementText(rowsLabel.get(6), "Hobbies");
//        for (String hobby : hobbies) {
//            elementMethods.validateElementTextSpecial(rowsValue.get(6),hobby);
//        }
////7 validate picture
//        elementMethods.validateElementText(rowsLabel.get(7), "Picture");
//        String[] arrayFileName = filePath.split("/");
//        Integer desireIndex = arrayFileName.length - 1;
//        elementMethods.validateElementText(rowsValue.get(7),arrayFileName[desireIndex]);
////8 validate address
//        elementMethods.validateElementText(rowsLabel.get(8), "Address");
//        elementMethods.validateElementText(rowsValue.get(8), addressValue);
////9 validate state and city
//        elementMethods.validateElementText(rowsLabel.get(9), "State and City");
//        elementMethods.validateElementText(rowsValue.get(9), cityValue + " " + stateValue);
    }
}