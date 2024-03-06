package tests;

import helperMethods.ElementMethods;
import helperMethods.SelectMethod;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.io.File;
import java.util.*;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        SelectMethod selectMethod = new SelectMethod(getWebDriver());

//intram pe pagina practice forms
        WebElement practiceFormElement = getWebDriver().findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElem(practiceFormElement);
        WebElement practiceFormElementA = getWebDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElem(practiceFormElementA);
//first name 0.1
        WebElement firstNameElement = getWebDriver().findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Tudor";
        elementMethods.fillString(firstNameElement, firstNameValue);
//last name 0.2
        WebElement lastNameElement = getWebDriver().findElement(By.cssSelector("input[placeholder='Last Name'"));
        String lastNameValue = "Hody";
        elementMethods.fillString(lastNameElement, lastNameValue);
//email 1
        WebElement emailElement = getWebDriver().findElement(By.xpath("//input[@placeholder='name@example.com']"));
        String emailValue = "thlhody@gmail.com";
        elementMethods.fillString(emailElement, emailValue);

        //radio box trebuie sa mearga dupa input daca nu dupa label
        //WebElement genderElement = webDriver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        //genderElement.click();
//gender 2
        String genderValue = "Male";
        if (Objects.equals(genderValue, "Male")) {
            WebElement genderRadioBox = getWebDriver().findElement(By.cssSelector("label[for='gender-radio-1']"));
            elementMethods.clickElem(genderRadioBox);
        } else if (Objects.equals(genderValue, "Female")) {
            WebElement genderRadioBox = getWebDriver().findElement(By.cssSelector("label[for='gender-radio-2']"));
            elementMethods.clickElem(genderRadioBox);
        } else {
            WebElement genderRadioBox = getWebDriver().findElement(By.cssSelector("label[for='gender-radio-3']"));
            elementMethods.clickElem(genderRadioBox);
        }
//mobile 3
        WebElement mobilElement = getWebDriver().findElement(By.cssSelector("input[placeholder='Mobile Number'"));
        String mobilValue = "0777227750";
        elementMethods.fillString(mobilElement, mobilValue);

        WebElement dobField = getWebDriver().findElement(By.cssSelector(".react-datepicker__input-container"));
        elementMethods.clickElem(dobField);

        WebElement dobMonth = getWebDriver().findElement(By.cssSelector(".react-datepicker__month-select"));
        String dobMonthElem = "August";
        selectMethod.selectObj(dobMonth, dobMonthElem);

        WebElement dobYear = getWebDriver().findElement(By.cssSelector(".react-datepicker__year-select"));
        String dobYearElem = "1985";
        selectMethod.selectObj(dobYear, dobYearElem);

        String dobDayValue = "29";
        List<WebElement> dobDayElem = getWebDriver().findElements(By.xpath("//div[not(contains(@class,'outside-month')) " +
                "and contains(@class,'react-datepicker__day react-datepicker__day')]"));
        for (Integer i = 0; i < dobDayElem.size(); i++) {
            if (dobDayElem.get(i).getText().equals(dobDayValue)) {
                elementMethods.clickElemForce(dobDayElem.get(i));
                break;
            }
        }

        //WebElement dobDayElem = webDriver.findElement(By.xpath("//div[not(contains(@class,'outside-month')) " +
        //        "and contains(@class,'react-datepicker__day react-datepicker__day') and text()='" + dobDayValue + "']"));
        //js.executeScript("arguments[0].click();",dobDayElem);

        //aici cautam toate zilele din luna selectata
        // //div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]
        //sau //div[not(contains(@class,'react-datepicker__day--outside-month')) and  contains(@class,'react-datepicker__day') and contains(@class,'react-datepicker__day--')]

//hobbies 5
        //WebElement hobbyElement = webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
        //hobbyElement.click();

        //div[@id='hobbiesWrapper']//label[@class='custom-control-label']
        //facem un algoritm case sa imi selecteze valorile pe care i le specific

        List<String> hobbies = Arrays.asList("Sports", "Music", "Reading");
        List<WebElement> hobbiesElem = getWebDriver().findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
        for (int i = 0; i < hobbiesElem.size(); i++) {
            String currentElemText = hobbiesElem.get(i).getText();
            if (hobbies.contains(currentElemText)) {
                elementMethods.clickElemForce(hobbiesElem.get(i));
            }
        }
//picture upload 6
        WebElement pictureUploadButton = getWebDriver().findElement(By.id("uploadPicture"));
        String filePath = "src/test/resources/uploadpic.jpg";
        elementMethods.fillString(pictureUploadButton,new File(filePath).getAbsolutePath());
//address 7
        WebElement addressField = getWebDriver().findElement(By.id("currentAddress"));
        String addressValue = "test";
        elementMethods.fillString(addressField,addressValue);
//subjects 8
        WebElement subjectField = getWebDriver().findElement(By.id("subjectsInput"));
        String subjectValue = "Economics";
        elementMethods.fillString(subjectField,subjectValue);
        elementMethods.fillKeys(subjectField,Keys.ENTER);
//state 9.1
        WebElement selectStateField = getWebDriver().findElement(By.xpath("//div[text()='Select State']"));
        elementMethods.clickElemForce(selectStateField);
        WebElement selectStateInputField = getWebDriver().findElement(By.id("react-select-3-input"));
        String cityValue = "Uttar Pradesh";
        elementMethods.fillString(selectStateInputField,cityValue);
        elementMethods.fillKeys(selectStateInputField,Keys.ENTER);
//city 9.2
        WebElement selectCityField = getWebDriver().findElement(By.xpath("//div[text()='Select City']"));
        elementMethods.clickElemForce(selectCityField);
        WebElement selectCityInputField = getWebDriver().findElement(By.id("react-select-4-input"));
        String stateValue = "Lucknow";
        elementMethods.fillString(selectCityInputField,stateValue);
        elementMethods.fillKeys(selectCityInputField,Keys.ENTER);
//submit
        WebElement submitButton = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElemForce(submitButton);
//assert validari
        //xpath : //table/tbody/tr/td[1] - dintre 2 frati cu aceelasi nume(tr) incep de la 1 primu 2 al doilea ....etc
        //validam tabelul cu valori

        List<WebElement> rowsLabel = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<WebElement> rowsValue = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));
//0 validate first name and last name
        elementMethods.validateElementText(rowsLabel.get(0), "Student Name");
        elementMethods.validateElementText(rowsValue.get(0), firstNameValue + " " + lastNameValue);
//1 validate student email
        elementMethods.validateElementText(rowsLabel.get(1), "Student Email");
        elementMethods.validateElementText(rowsValue.get(1), emailValue);
//2 validate gender
        elementMethods.validateElementText(rowsLabel.get(2), "Gender");
        elementMethods.validateElementText(rowsValue.get(2), genderValue);
//3 validate mobile
        elementMethods.validateElementText(rowsLabel.get(3), "Mobile");
        elementMethods.validateElementText(rowsValue.get(3), mobilValue);
//4 validate date of birth
        String dobDayValueFormatted;
        if (Integer.parseInt(dobDayValue) >= 1 && Integer.parseInt(dobDayValue) <= 9) {
            dobDayValueFormatted = "0" + dobDayValue;
        } else {
            dobDayValueFormatted = dobDayValue;
        }
        elementMethods.validateElementText(rowsLabel.get(4), "Date of Birth");
        elementMethods.validateElementText(rowsValue.get(4), dobDayValueFormatted + " " + dobMonthElem + "," + dobYearElem);
//5 validate subjects
        elementMethods.validateElementText(rowsLabel.get(5), "Subjects");
        elementMethods.validateElementText(rowsValue.get(5), subjectValue);
//6 validate hobbies
        elementMethods.validateElementText(rowsLabel.get(6), "Hobbies");
        for (String hobby : hobbies) {
            elementMethods.validateElementTextSpecial(rowsValue.get(6),hobby);
        }
//7 validate picture
        elementMethods.validateElementText(rowsLabel.get(7), "Picture");
        String[] arrayFileName = filePath.split("/");
        Integer desireIndex = arrayFileName.length - 1;
        elementMethods.validateElementText(rowsValue.get(7),arrayFileName[desireIndex]);
//8 validate address
        elementMethods.validateElementText(rowsLabel.get(8), "Address");
        elementMethods.validateElementText(rowsValue.get(8), addressValue);
//9 validate state and city
        elementMethods.validateElementText(rowsLabel.get(9), "State and City");
        elementMethods.validateElementText(rowsValue.get(9), cityValue + " " + stateValue);
    }
}

