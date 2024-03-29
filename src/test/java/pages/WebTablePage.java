package pages;

import object.data.WebTableObject;
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
        elementMethods.fillString(firstNameElement, webTableObject.getFirstNameValue());
        elementMethods.fillString(lastNameElement, webTableObject.getLastNameValue());
        elementMethods.fillString(emailElement, webTableObject.getEmailValue());
        elementMethods.fillString(ageElement, webTableObject.getAgeValue());
        elementMethods.fillString(salaryElement, webTableObject.getSalaryValue());
        elementMethods.fillString(departamentElement, webTableObject.getDepartamentValue());
        elementMethods.clickElem(submitButton);
    }

    public void editEntry(WebTableObject webTableObject) {

        elementMethods.clickElem(editButton);
        elementMethods.refillString(firstNameElement, webTableObject.getFirstNameValue());
        elementMethods.refillString(lastNameElement, webTableObject.getLastNameValue());
        elementMethods.refillString(emailElement, webTableObject.getEmailValue());
        elementMethods.refillString(ageElement, webTableObject.getAgeValue());
        elementMethods.refillString(salaryElement, webTableObject.getSalaryValue());
        elementMethods.refillString(departamentElement, webTableObject.getDepartamentValue());
        elementMethods.clickElem(submitButton);
    }

    public void deleteEntry() {
        elementMethods.clickElem(deleteButton);
    }
}
