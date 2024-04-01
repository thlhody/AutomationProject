package pages;


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
    }

    public void fillLastName(String lastNameValue) {
        elementMethods.fillString(lastNameField, lastNameValue);
    }

    public void fillEmail(String emailValue) {
        elementMethods.fillString(emailField, emailValue);
    }

    public void fillMobile(String mobileValue) {
        elementMethods.fillString(mobileField, mobileValue);
    }

    public void fillDob(String dobDayValue, String dobMonthValue, String dobYearValue) {
        elementMethods.clickElem(dobField);
        selectMethod.selectObj(dobMonthField, dobMonthValue);
        selectMethod.selectObj(dobYearField, dobYearValue);
        for (Integer i = 0; i < dobDayField.size(); i++) {
            if (dobDayField.get(i).getText().equals(dobDayValue)) {
                elementMethods.clickElemForce(dobDayField.get(i));
                break;
            }
        }
    }

    public void pickHobbies(List<String> hobbies) {
        for (int i = 0; i < hobbiesField.size(); i++) {
            String currentElemText = hobbiesField.get(i).getText();
            if (hobbies.contains(currentElemText)) {
                elementMethods.clickElemForce(hobbiesField.get(i));
            }
        }
    }

    public void pictureUpload(String filePath) {
        elementMethods.fillString(pictureField, new File(filePath).getAbsolutePath());
    }

    public void fillAddress(String addressValue) {
        elementMethods.fillString(addressField, addressValue);
    }

    public void fillSubjects(String subjectValue) {
        elementMethods.fillString(subjectsField, subjectValue);
        elementMethods.fillKeys(subjectsField, Keys.ENTER);
    }

    public void fillState(String stateValue) {
        elementMethods.scrollElemByPixel(0, 450);
        elementMethods.clickElemForce(selectStateField);
        elementMethods.fillString(inputStateField, stateValue);
        elementMethods.fillKeys(inputStateField, Keys.ENTER);
    }

    public void fillCity(String cityValue) {
        elementMethods.clickElemForce(selectCityField);
        elementMethods.fillString(inputCityField, cityValue);
        elementMethods.fillKeys(inputCityField, Keys.ENTER);
    }

    public void fillGender(String genderValue) {
        if (Objects.equals(genderValue, "Male")) {
            elementMethods.clickElem(male);
        } else if (Objects.equals(genderValue, "Female")) {
            elementMethods.clickElem(female);
        } else {
            elementMethods.clickElem(other);
        }
    }

    public void submit() {
        elementMethods.clickElemForce(submitButton);
    }

    public void validatePracticeForm(PracticeFormObject practiceFormObject) {

//0 validate first name and last name
        elementMethods.validateElementText(rowsLabel.get(0), "Student Name");
        elementMethods.validateElementText(rowsValue.get(0), practiceFormObject.getFirstNameValue() + " "
                + practiceFormObject.getLastNameValue());
//1 validate student email
        elementMethods.validateElementText(rowsLabel.get(1), "Student Email");
        elementMethods.validateElementText(rowsValue.get(1), practiceFormObject.getEmailValue());
//2 validate gender
        elementMethods.validateElementText(rowsLabel.get(2), "Gender");
        elementMethods.validateElementText(rowsValue.get(2), practiceFormObject.getGenderValue());
//3 validate mobile
        elementMethods.validateElementText(rowsLabel.get(3), "Mobile");
        elementMethods.validateElementText(rowsValue.get(3), practiceFormObject.getMobilValue());
//4 validate date of birth
        String dobDayValueFormatted;
        if (Integer.parseInt(practiceFormObject.getDobDayValue()) >= 1 && Integer.parseInt(practiceFormObject.getDobDayValue()) <= 9) {
            dobDayValueFormatted = "0" + practiceFormObject.getDobDayValue();
        } else {
            dobDayValueFormatted = practiceFormObject.getDobDayValue();
        }
        elementMethods.validateElementText(rowsLabel.get(4), "Date of Birth");
        elementMethods.validateElementText(rowsValue.get(4), dobDayValueFormatted + " " + practiceFormObject.getDobMonthValue() + ","
                + practiceFormObject.getDobYearValue());
//5 validate subjects
        elementMethods.validateElementText(rowsLabel.get(5), "Subjects");
        elementMethods.validateElementText(rowsValue.get(5), practiceFormObject.getSubjectValue());
//6 validate hobbies
        elementMethods.validateElementText(rowsLabel.get(6), "Hobbies");
        for (String hobby : practiceFormObject.getHobbies()) {
            elementMethods.validateElementTextSpecial(rowsValue.get(6), hobby);
        }
//7 validate picture
        elementMethods.validateElementText(rowsLabel.get(7), "Picture");
        String[] arrayFileName = practiceFormObject.getFilePath().split("/");
        Integer desireIndex = arrayFileName.length - 1;
        elementMethods.validateElementText(rowsValue.get(7), arrayFileName[desireIndex]);
//8 validate address
        elementMethods.validateElementText(rowsLabel.get(8), "Address");
        elementMethods.validateElementText(rowsValue.get(8), practiceFormObject.getAddressValue());
//9 validate state and city
        elementMethods.validateElementText(rowsLabel.get(9), "State and City");
        elementMethods.validateElementText(rowsValue.get(9), practiceFormObject.getStateValue() + " " + practiceFormObject.getCityValue());
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