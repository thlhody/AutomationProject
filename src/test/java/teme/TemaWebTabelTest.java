package teme;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class TemaWebTabelTest {

    public void metodaPrincipala(WebDriver webDriver) {
        accessElementWebTables(webDriver);
        webElementTest(webDriver, "Tudor","Hody","thlhody@gmail.com","34","2500","IT");
        webElementTest(webDriver,"Gheorghe","Eugen","gheorghe@yahoo.com","55","4500","HR");
        modificamDate(webDriver,"Andrei","Vasile","andrei.v@gmail.com","21","10000","Grafica");
        stergemDate(webDriver);
    }

    public void accessElementWebTables(WebDriver webDriver){
        WebElement elementButton = webDriver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);",elementButton);
        elementButton.click();

        WebElement webElementButton= webDriver.findElement(By.xpath("//span[text()='Web Tables']"));
        webElementButton.click();

    }
    public void webElementTest(WebDriver webDriver, String firstNameValue, String lastNameValue, String emailValue, String ageValue,
                               String salaryValue, String departmentValue) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        WebElement addNewRecordButton = webDriver.findElement(By.id("addNewRecordButton"));
        js.executeScript("arguments[0].click();",addNewRecordButton);

        WebElement firstNameElement = webDriver.findElement(By.id("firstName"));
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = webDriver.findElement(By.id("lastName"));
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = webDriver.findElement(By.id("userEmail"));
        emailElement.sendKeys(emailValue);

        WebElement ageElement = webDriver.findElement(By.id("age"));
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = webDriver.findElement(By.id("salary"));
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = webDriver.findElement(By.id("department"));
        departmentElement.sendKeys(departmentValue);

        WebElement submitButton = webDriver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();",submitButton);
    }
    public void modificamDate(WebDriver webDriver, String firstNameValue, String lastNameValue, String emailValue, String ageValue,
                              String salaryValue, String departmentValue){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        WebElement editButton = webDriver.findElement(By.id("edit-record-4"));
        js.executeScript("arguments[0].click();",editButton);

        WebElement firstNameElement = webDriver.findElement(By.id("firstName"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = webDriver.findElement(By.id("lastName"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = webDriver.findElement(By.id("userEmail"));
        emailElement.clear();
        emailElement.sendKeys(emailValue);

        WebElement ageElement = webDriver.findElement(By.id("age"));
        ageElement.clear();
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = webDriver.findElement(By.id("salary"));
        salaryElement.clear();
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = webDriver.findElement(By.id("department"));
        departmentElement.clear();
        departmentElement.sendKeys(departmentValue);

        WebElement submitButton = webDriver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();",submitButton);
    }
    public void stergemDate(WebDriver webDriver){

        WebElement deleteButton5 = webDriver.findElement(By.id("delete-record-5"));
        deleteButton5.click();

        WebElement deleteButton4 = webDriver.findElement(By.id("delete-record-4"));
        deleteButton4.click();
    }

}
