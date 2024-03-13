package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver webDriver){
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

    public void addNewEntry (String firstNameValue, String lastNameValue, String emailValue, String ageValue, String salaryValue, String departamentValue) {

        elementMethods.clickElem(addNewRecordButton);
        elementMethods.fillString(firstNameElement, firstNameValue);
        elementMethods.fillString(lastNameElement, lastNameValue);
        elementMethods.fillString(emailElement, emailValue);
        elementMethods.fillString(ageElement, ageValue);
        elementMethods.fillString(salaryElement, salaryValue);
        elementMethods.fillString(departamentElement, departamentValue);
        elementMethods.clickElem(submitButton);
    }
    public void editEntry(String firstNameValue,String lastNameValue, String emailValue, String ageValue, String salaryValue, String departamentValue){

        elementMethods.clickElem(editButton);
        elementMethods.refillString(firstNameElement,firstNameValue);
        elementMethods.refillString(lastNameElement, lastNameValue);
        elementMethods.refillString(emailElement, emailValue);
        elementMethods.refillString(ageElement, ageValue);
        elementMethods.refillString(salaryElement, salaryValue);
        elementMethods.refillString(departamentElement, departamentValue);
        elementMethods.clickElem(submitButton);
    }
    public void deleteEntry(){
        elementMethods.clickElem(deleteButton);
    }
}
