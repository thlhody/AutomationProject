package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Arrays;
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
    public void fillFirstName(String firstNameValue){
        elementMethods.fillString(firstNameField, firstNameValue);
    }
    public void fillLastName(String lastNameValue){
        elementMethods.fillString(lastNameField, lastNameValue);
    }
    public void fillemail(String emailValue){
        elementMethods.fillString(emailField, emailValue);
    }
    public void fillmobile(String mobileValue){
        elementMethods.fillString(mobileField, mobileValue);
    }
    public void fillDob(String dobDayValue,String dobMonthValue,String dobYearValue){
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
    public void pickHobbies(List<String> hobbies){
        for (int i = 0; i < hobbiesField.size(); i++) {
            String currentElemText = hobbiesField.get(i).getText();
            if (hobbies.contains(currentElemText)) {
                elementMethods.clickElemForce(hobbiesField.get(i));
            }
        }
    }
    public void pictureUpload(String filePath){
        elementMethods.fillString(pictureField,new File(filePath).getAbsolutePath());
    }
    public void fillAddress(String addressValue){
        elementMethods.fillString(addressField,addressValue);
    }
    public void fillSubjects(String subjectValue){
        elementMethods.fillString(subjectsField,subjectValue);
        elementMethods.fillKeys(subjectsField, Keys.ENTER);
    }

    public void fillState(String stateValue){
        elementMethods.scrollElemByPixel(0,450);
        elementMethods.clickElemForce(selectStateField);
        elementMethods.fillString(inputStateField,stateValue);
        elementMethods.fillKeys(inputStateField,Keys.ENTER);
    }
    public void fillCity(String cityValue){
        elementMethods.clickElemForce(selectCityField);
        elementMethods.fillString(inputCityField,cityValue);
        elementMethods.fillKeys(inputCityField,Keys.ENTER);
    }

    public void submit(){
        elementMethods.clickElemForce(submitButton);
    }

    public void fillGender(String genderValue){
        if (Objects.equals(genderValue, "Male")) {
            elementMethods.clickElem(male);
        } else if (Objects.equals(genderValue, "Female")) {
            elementMethods.clickElem(female);
        } else {
            elementMethods.clickElem(other);
        }
    }


}