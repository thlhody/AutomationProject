package pages;

import loggerUtility.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButton;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departamentElement;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "edit-record-4")
    private WebElement editButton;
    @FindBy(id = "delete-record-4")
    private WebElement deleteButton;

    public void addNewEntry(WebTableObject webTableObject) {

        elementMethods.clickElem(addNewRecordButton);
        LoggerUtility.infoTest("User clicks on add new record");

        elementMethods.fillString(firstNameElement, webTableObject.getFirstNameValue());
        LoggerUtility.infoTest("User fills with: "+webTableObject.getFirstNameValue());

        elementMethods.fillString(lastNameElement, webTableObject.getLastNameValue());
        LoggerUtility.infoTest("User fills with: "+webTableObject.getLastNameValue());

        elementMethods.fillString(emailElement, webTableObject.getEmailValue());
        LoggerUtility.infoTest("User fills with: "+webTableObject.getEmailValue());

        elementMethods.fillString(ageElement, webTableObject.getAgeValue());
        LoggerUtility.infoTest("User fills with: "+webTableObject.getAgeValue());

        elementMethods.fillString(salaryElement, webTableObject.getSalaryValue());
        LoggerUtility.infoTest("User fills with: "+webTableObject.getSalaryValue());

        elementMethods.fillString(departamentElement, webTableObject.getDepartamentValue());
        LoggerUtility.infoTest("User fills with: "+webTableObject.getDepartamentValue());

        elementMethods.clickElem(submitButton);
        LoggerUtility.infoTest("User clicks submit button");
    }

    public void editEntry(WebTableObject webTableObject) {

        elementMethods.clickElem(editButton);
        LoggerUtility.infoTest("User clicks on edit record");

        elementMethods.refillString(firstNameElement, webTableObject.getFirstNameValue());
        LoggerUtility.infoTest("User refills with: "+webTableObject.getFirstNameValue());

        elementMethods.refillString(lastNameElement, webTableObject.getLastNameValue());
        LoggerUtility.infoTest("User refills with: "+webTableObject.getLastNameValue());

        elementMethods.refillString(emailElement, webTableObject.getEmailValue());
        LoggerUtility.infoTest("User refills with: "+webTableObject.getEmailValue());

        elementMethods.refillString(ageElement, webTableObject.getAgeValue());
        LoggerUtility.infoTest("User refills with: "+webTableObject.getAgeValue());

        elementMethods.refillString(salaryElement, webTableObject.getSalaryValue());
        LoggerUtility.infoTest("User refills with: "+webTableObject.getSalaryValue());

        elementMethods.refillString(departamentElement, webTableObject.getDepartamentValue());
        LoggerUtility.infoTest("User refills with: "+webTableObject.getDepartamentValue());

        elementMethods.clickElem(submitButton);
        LoggerUtility.infoTest("User clicks submit button");
    }

    public void deleteEntry() {
        elementMethods.clickElem(deleteButton);
        LoggerUtility.infoTest("User clicks delete record button");

    }
}
