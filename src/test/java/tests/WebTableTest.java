package tests;

import helperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() throws InterruptedException {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement elementFieldElement = getWebDriver().findElement(By.xpath("//h5[text()='Elements']"));
        elementFieldElement.click();

        //scroll by 500px
        //((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,500)");
        //scroll by element sa fie vizibil
        //((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);",elementFieldElement);
        //scroll to scroll pagina pana la o pozitie specifica
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //modelul de mai sus cheama direct JavascriptExecutor
        //modelul aceasta creeaza variabila js in care memoreaza actiunea ca sa o putem folosi mai incolo.
        //JavascriptExecutor js = (JavascriptExecutor) webdriver;
        //js.executeScript("window.scrollBy(0,250)", "");


        WebElement webElementField = getWebDriver().findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickElem(webElementField);

        WebElement addNewRecordButton = getWebDriver().findElement(By.id("addNewRecordButton"));
        elementMethods.clickElem(addNewRecordButton);

        WebElement firstNameElement = getWebDriver().findElement(By.id("firstName"));
        String firstNameValue="Tudor";
        elementMethods.fillString(firstNameElement,firstNameValue);

        WebElement lastNameElement = getWebDriver().findElement(By.id("lastName"));
        String lastNameValue="Hody";
        elementMethods.fillString(lastNameElement,lastNameValue);

        WebElement emailElement = getWebDriver().findElement(By.id("userEmail"));
        String emailValue="thlhody@gmail.com";
        elementMethods.fillString(emailElement,emailValue);

        WebElement ageElement = getWebDriver().findElement(By.id("age"));
        String ageValue="34";
        elementMethods.fillString(ageElement,ageValue);

        WebElement salaryElement = getWebDriver().findElement(By.id("salary"));
        String salaryValue="1000";
        elementMethods.fillString(salaryElement,salaryValue);

        WebElement departamentElement = getWebDriver().findElement(By.id("department"));
        String departamentValue="IT";
        elementMethods.fillString(departamentElement,departamentValue);

        WebElement submitButton = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElem(submitButton);
        editButton();

        Thread.sleep(5000);// ca sa se vada schimbarile , altfel nu se foloseste.

        WebElement deleteButton = getWebDriver().findElement(By.id("delete-record-4"));
        elementMethods.clickElem(deleteButton);
    }
    public void editButton() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        WebElement editButton = getWebDriver().findElement(By.id("edit-record-4"));
        elementMethods.clickElem(editButton);


        WebElement firstNameElement = getWebDriver().findElement(By.id("firstName"));
        String firstNameValue="Andrei";
        elementMethods.refillString(firstNameElement,firstNameValue);


        WebElement lastNameElement = getWebDriver().findElement(By.id("lastName"));
        String lastNameValue="Vasile";
        elementMethods.refillString(lastNameElement, lastNameValue);

        WebElement salaryElement = getWebDriver().findElement(By.id("salary"));
        String salaryValue="4000";
        elementMethods.refillString(salaryElement, salaryValue);

        WebElement departamentElement = getWebDriver().findElement(By.id("department"));
        String departamentValue="Grafica";
        elementMethods.refillString(departamentElement, departamentValue);

        WebElement submitButton = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElem(submitButton);

        // .close() - inchide un tab din browser
        // .quit() - inchide tot browserului cu toate taburile
    }
}
