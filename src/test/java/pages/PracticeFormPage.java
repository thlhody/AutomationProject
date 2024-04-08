package pages;


import loggerUtility.LoggerUtility;
import objectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameField;
    @FindBy(css = "input[placeholder='Last Name'")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    private WebElement emailField;
    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement male;
    @FindBy(css = "label[for='gender-radio-2']")
    private WebElement female;
    @FindBy(css = "label[for='gender-radio-3']")
    private WebElement other;
    @FindBy(css = "input[placeholder='Mobile Number'")
    private WebElement mobileField;
    @FindBy(css = ".react-datepicker__input-container")
    private WebElement dobField;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement dobMonthField;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement dobYearField;
    @FindBy(xpath = "//div[not(contains(@class,'outside-month')) " +
            "and contains(@class,'react-datepicker__day react-datepicker__day')]")
    private List<WebElement> dobDayField;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesField;
    @FindBy(id = "uploadPicture")
    private WebElement pictureField;
    @FindBy(id = "currentAddress")
    private WebElement addressField;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsField;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement selectStateField;
    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement selectCityField;
    @FindBy(id = "react-select-3-input")
    private WebElement inputStateField;
    @FindBy(id = "react-select-4-input")
    private WebElement inputCityField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> rowsLabel;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> rowsValue;

    public void fillFirstName(String firstNameValue) {
        elementMethods.fillString(firstNameField, firstNameValue);
        LoggerUtility.infoTest("User fills first name: "+firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementMethods.fillString(lastNameField, lastNameValue);
        LoggerUtility.infoTest("User fills last name: "+lastNameValue);
    }

    public void fillEmail(String emailValue) {
        elementMethods.fillString(emailField, emailValue);
        LoggerUtility.infoTest("User fills email: "+emailValue);
    }

    public void fillMobile(String mobileValue) {
        elementMethods.fillString(mobileField, mobileValue);
        LoggerUtility.infoTest("User fills mobile: "+mobileValue);
    }

    public void fillDob(String dobDayValue, String dobMonthValue, String dobYearValue) {
        elementMethods.clickElem(dobField);
        LoggerUtility.infoTest("User clicks date of birth field");
        selectMethod.selectObj(dobMonthField, dobMonthValue);
        LoggerUtility.infoTest("User select dob month : "+dobMonthValue);
        selectMethod.selectObj(dobYearField, dobYearValue);
        LoggerUtility.infoTest("User select dob year : "+dobYearValue);
        for (Integer i = 0; i < dobDayField.size(); i++) {
            if (dobDayField.get(i).getText().equals(dobDayValue)) {
                elementMethods.clickElemForce(dobDayField.get(i));
                break;
            }
        }
        LoggerUtility.infoTest("User clicks on dob day : "+dobDayValue);
    }

    public void pickHobbies(List<String> hobbies) {
        for (int i = 0; i < hobbiesField.size(); i++) {
            String currentElemText = hobbiesField.get(i).getText();
            if (hobbies.contains(currentElemText)) {
                elementMethods.clickElemForce(hobbiesField.get(i));
            }
        }
        LoggerUtility.infoTest("User select hobbies from list : "+hobbies);
    }

    public void pictureUpload(String filePath) {
        elementMethods.fillString(pictureField, new File(filePath).getAbsolutePath());
        LoggerUtility.infoTest("User uploads picture from: "+filePath);
    }

    public void fillAddress(String addressValue) {
        elementMethods.fillString(addressField, addressValue);
        LoggerUtility.infoTest("User fills address: "+addressValue);
    }

    public void fillSubjects(String subjectValue) {
        elementMethods.fillString(subjectsField, subjectValue);
        LoggerUtility.infoTest("User fills subject: "+subjectValue);
        elementMethods.fillKeys(subjectsField, Keys.ENTER);
        LoggerUtility.infoTest("User presses enter for subject: "+subjectValue);
    }

    public void fillState(String stateValue) {
        elementMethods.scrollElemByPixel(0, 450);
        LoggerUtility.infoTest("User scroll down by 450px");
        elementMethods.clickElemForce(selectStateField);
        LoggerUtility.infoTest("User clicks state field");
        elementMethods.fillString(inputStateField, stateValue);
        LoggerUtility.infoTest("User fills state field with : "+stateValue);
        elementMethods.fillKeys(inputStateField, Keys.ENTER);
        LoggerUtility.infoTest("User presses enter for state: "+stateValue);
    }

    public void fillCity(String cityValue) {
        elementMethods.clickElemForce(selectCityField);
        LoggerUtility.infoTest("User clicks city field");
        elementMethods.fillString(inputCityField, cityValue);
        LoggerUtility.infoTest("User fills city field with : "+cityValue);
        elementMethods.fillKeys(inputCityField, Keys.ENTER);
        LoggerUtility.infoTest("User presses enter for city: "+cityValue);
    }

    public void fillGender(String genderValue) {
        if (Objects.equals(genderValue, "Male")) {
            elementMethods.clickElem(male);
        } else if (Objects.equals(genderValue, "Female")) {
            elementMethods.clickElem(female);
        } else {
            elementMethods.clickElem(other);
        }
        LoggerUtility.infoTest("User clicks gender : "+genderValue);
    }

    public void submit() {
        elementMethods.clickElemForce(submitButton);
        LoggerUtility.infoTest("***** User clicks submit button! *****");
    }

    public void validatePracticeForm(PracticeFormObject practiceFormObject) {

//0 validate first name and last name
        elementMethods.validateElementText(rowsLabel.get(0), "Student Name");
        LoggerUtility.infoTest("User validates Student Name");

        elementMethods.validateElementText(rowsValue.get(0), practiceFormObject.getFirstNameValue() + " "
                + practiceFormObject.getLastNameValue());
        LoggerUtility.infoTest("User validates First and Last Name: "+ practiceFormObject.getFirstNameValue() + " "
                + practiceFormObject.getLastNameValue());

//1 validate student email
        elementMethods.validateElementText(rowsLabel.get(1), "Student Email");
        LoggerUtility.infoTest("User validates Student Email");

        elementMethods.validateElementText(rowsValue.get(1), practiceFormObject.getEmailValue());
        LoggerUtility.infoTest("User validates Email: "+practiceFormObject.getEmailValue());

//2 validate gender
        elementMethods.validateElementText(rowsLabel.get(2), "Gender");
        LoggerUtility.infoTest("User validates Gender");

        elementMethods.validateElementText(rowsValue.get(2), practiceFormObject.getGenderValue());
        LoggerUtility.infoTest("User validates Gender: "+practiceFormObject.getGenderValue());

//3 validate mobile
        elementMethods.validateElementText(rowsLabel.get(3), "Mobile");
        LoggerUtility.infoTest("User validates Mobile");
        elementMethods.validateElementText(rowsValue.get(3), practiceFormObject.getMobilValue());
        LoggerUtility.infoTest("User validates Mobile: "+practiceFormObject.getMobilValue());
//4 validate date of birth
        String dobDayValueFormatted;
        if (Integer.parseInt(practiceFormObject.getDobDayValue()) >= 1 && Integer.parseInt(practiceFormObject.getDobDayValue()) <= 9) {
            dobDayValueFormatted = "0" + practiceFormObject.getDobDayValue();
        } else {
            dobDayValueFormatted = practiceFormObject.getDobDayValue();
        }

        elementMethods.validateElementText(rowsLabel.get(4), "Date of Birth");
        LoggerUtility.infoTest("User validates Date of Birth");

        elementMethods.validateElementText(rowsValue.get(4), dobDayValueFormatted + " " + practiceFormObject.getDobMonthValue() + ","
                + practiceFormObject.getDobYearValue());
        LoggerUtility.infoTest("User validates Date of birth: "+dobDayValueFormatted + " " + practiceFormObject.getDobMonthValue() + ","
                + practiceFormObject.getDobYearValue());

//5 validate subjects
        elementMethods.validateElementText(rowsLabel.get(5), "Subjects");
        LoggerUtility.infoTest("User validates Subjects");

        elementMethods.validateElementText(rowsValue.get(5), practiceFormObject.getSubjectValue());
        LoggerUtility.infoTest("User validates Subjects: "+practiceFormObject.getSubjectValue());

//6 validate hobbies
        elementMethods.validateElementText(rowsLabel.get(6), "Hobbies");
        LoggerUtility.infoTest("User validates Hobbies");

        for (String hobby : practiceFormObject.getHobbies()) {
            elementMethods.validateElementTextSpecial(rowsValue.get(6), hobby);
        }
        LoggerUtility.infoTest("User validates Hobbies: "+practiceFormObject.getHobbies());
//7 validate picture
        elementMethods.validateElementText(rowsLabel.get(7), "Picture");
        LoggerUtility.infoTest("User validates Picture");

        String[] arrayFileName = practiceFormObject.getFilePath().split("/");
        Integer desireIndex = arrayFileName.length - 1;
        elementMethods.validateElementText(rowsValue.get(7), arrayFileName[desireIndex]);
        LoggerUtility.infoTest("User validates Picture name: "+arrayFileName[desireIndex]);

//8 validate address
        elementMethods.validateElementText(rowsLabel.get(8), "Address");
        LoggerUtility.infoTest("User validates Address");

        elementMethods.validateElementText(rowsValue.get(8), practiceFormObject.getAddressValue());
        LoggerUtility.infoTest("User validates Address: "+practiceFormObject.getAddressValue());

//9 validate state and city
        elementMethods.validateElementText(rowsLabel.get(9), "State and City");
        LoggerUtility.infoTest("User validates State and City");

        elementMethods.validateElementText(rowsValue.get(9), practiceFormObject.getStateValue() + " " + practiceFormObject.getCityValue());
        LoggerUtility.infoTest("User validates State and City : "+practiceFormObject.getStateValue() + " " + practiceFormObject.getCityValue());
    }

    public void fillEntireForm(PracticeFormObject practiceFormObject) {

//first name 0.1
        fillFirstName(practiceFormObject.getFirstNameValue());
//last name 0.2
        fillLastName(practiceFormObject.getLastNameValue());
//email 1
        fillEmail(practiceFormObject.getEmailValue());
//gender 2
        fillGender(practiceFormObject.getGenderValue());
//mobile 3
        fillMobile(practiceFormObject.getMobilValue());
//date of birth 4
        fillDob(practiceFormObject.getDobDayValue(), practiceFormObject.getDobMonthValue(),
                practiceFormObject.getDobYearValue());
        //hobbies 5
        pickHobbies(practiceFormObject.getHobbies());
//picture upload 6
        pictureUpload(practiceFormObject.getFilePath());
//address 7
        fillAddress(practiceFormObject.getAddressValue());
//subjects 8
        fillSubjects(practiceFormObject.getSubjectValue());
//state 9.1
        fillState(practiceFormObject.getStateValue());
//city 9.2
        fillCity(practiceFormObject.getCityValue());
//submit
        submit();
    }
}