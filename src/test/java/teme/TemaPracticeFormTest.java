package teme;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.util.*;
import java.util.List;

public class TemaPracticeFormTest {

    public void metodaPrincipala(WebDriver webDriver) {
        File filelocation = new File("src/test/resources/uploadpic.jpg");

        accessPracticeForm(webDriver);
        practiceFormTest(webDriver, "Tudor", "Hody", "thlhody@gmail.com", "Male",
                filelocation.getAbsolutePath(), "0123456789", "29 July,1908",
                "Physics, Maths, Hindi, Chemistry", "Sports, Reading, Music", "str strda nr 10",
                "NCR", "Delhi");
        practiceFormTest(webDriver, "Andreeee", "Pastarnac", "Andreea01_geo@yahoo.com", "Female",
                filelocation.getAbsolutePath(), "0725544681", "29 October,1950",
                "Economics, Arts, Social Studies, History", "Music", "str grigore nr 1121",
                "Rajasthan", "Jaiselmer");
    }
    public void accessPracticeForm(WebDriver webDriver) {
        WebElement practiceFormButton = webDriver.findElement(By.xpath("//h5[text()='Forms']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", practiceFormButton);
        practiceFormButton.click();
        WebElement practiceFormButton2 = webDriver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormButton2.click();

    }
    public void practiceFormTest(WebDriver webDriver, String firstNameValue, String lastNameValue, String emailValue, String genderValue, String locatiePoza,
                                 String mobilValue, String dobValue, String subjectsValue, String hobbiesValue, String addressValue, String stateValue,
                                 String cityValue) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//FIRSTNAME 1/1
        WebElement firstNameField = webDriver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstNameField.sendKeys(firstNameValue);
//LASTNAME 1/2
        WebElement lastNameField = webDriver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastNameField.sendKeys(lastNameValue);
//EMAIL 2
        WebElement emailField = webDriver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        emailField.sendKeys(emailValue);
//GENDER 3
        if(Objects.equals(genderValue,"Male")) {
            WebElement genderRadioBox = webDriver.findElement(By.cssSelector("label[for='gender-radio-1']"));
            genderRadioBox.click();
        } else if(Objects.equals(genderValue,"Female")) {
            WebElement genderRadioBox = webDriver.findElement(By.cssSelector("label[for='gender-radio-2']"));
            genderRadioBox.click();
        } else {
            WebElement genderRadioBox = webDriver.findElement(By.cssSelector("label[for='gender-radio-3']"));
            genderRadioBox.click();
        }
//MOBILE 4
        WebElement mobilField = webDriver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        mobilField.sendKeys(mobilValue);
//DATEOFBIRTH 5
        String[] dobAdd = dobValue.split("\\s+");
        WebElement dobField = webDriver.findElement(By.id("dateOfBirthInput"));
        dobField.click();
        dobField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Actions actions1 = new Actions(webDriver);
        for (String dob : dobAdd) {
            actions1.sendKeys(dob).sendKeys(Keys.SPACE);
        }
        actions1.build().perform();
        dobField.sendKeys(Keys.ESCAPE);
//SUBJECTS 6
        String delimitatorS = ", ";
        String[] subjectsAdd = subjectsValue.split(delimitatorS);
        WebElement subjectField = webDriver.findElement(By.id("subjectsInput"));
        subjectField.click();
        for (String subject : subjectsAdd) {
            if (subject.length()>=3) {
                Actions actions = new Actions(webDriver);
                actions.sendKeys(String.valueOf(subject.charAt(0)))
                        .sendKeys(String.valueOf(subject.charAt(1)))
                        .sendKeys(String.valueOf(subject.charAt(2)))
                        .perform();
                subjectField.sendKeys(Keys.ENTER);
            }
        }
//HOBBIES 7/1
//        List<String> hobbies = Arrays.asList("Sports","Music","Reading");
//        List<WebElement> hobbiesElem = webDriver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
//        for(int i=0; i<hobbiesElem.size(); i++){
//            String currentElemText = hobbiesElem.get(i).getText();
//            if(hobbies.contains(currentElemText)){
//                hobbiesElem.get(i).click();
//            }
//        }
//HOBBIIES 7/2
        String delimitatorH = ", ";
        String[] hobbiesAdd = hobbiesValue.split(delimitatorH);
        for (String hobbiesN : hobbiesAdd) {
            if (Objects.equals(hobbiesN, "Sports")) {
                WebElement hobbiesCheckBox = webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
                hobbiesCheckBox.click();
            } else if (Objects.equals(hobbiesN, "Reading")) {
                WebElement hobbiesCheckBox = webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
                hobbiesCheckBox.click();
            } else if (Objects.equals(hobbiesN, "Music")) {
                WebElement hobbiesCheckBox = webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
                hobbiesCheckBox.click();
            }
        }

//PICTURE 8
        WebElement pictureUploadButton = webDriver.findElement(By.id("uploadPicture"));
        pictureUploadButton.sendKeys(locatiePoza);
//ADDRESS 9
        WebElement addressField = webDriver.findElement(By.id("currentAddress"));
        addressField.sendKeys(addressValue);
//STATE 10/1
        WebElement selectStateField = webDriver.findElement(By.xpath("//div[text()='Select State']"));
        js.executeScript("arguments[0].click();",selectStateField);
        WebElement selectStateInputField = webDriver.findElement(By.id("react-select-3-input"));
        selectStateInputField.sendKeys(stateValue);
        selectStateInputField.sendKeys(Keys.ENTER);
//CITY  10/2
        WebElement selectCityField = webDriver.findElement(By.xpath("//div[text()='Select City']"));
        js.executeScript("arguments[0].click();",selectCityField);
        WebElement selectCityInputField = webDriver.findElement(By.id("react-select-4-input"));
        selectCityInputField.sendKeys(cityValue);
        selectCityInputField.sendKeys(Keys.ENTER);
//SUBMIT BUTTON
        WebElement submitButton = webDriver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();",submitButton);
//ASSERT CHECK BOTH LABEL AND VALUES
        List<WebElement> rowsLabel = webDriver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<WebElement> rowsValue = webDriver.findElements(By.xpath("//table/tbody/tr/td[2]"));

       Assert.assertEquals(rowsLabel.get(0).getText(),"Student Name");
       Assert.assertEquals(rowsValue.get(0).getText(),firstNameValue+" "+lastNameValue);

       Assert.assertEquals(rowsLabel.get(1).getText(),"Student Email");
        Assert.assertEquals(rowsValue.get(1).getText(),emailValue);

       Assert.assertEquals(rowsLabel.get(2).getText(),"Gender");
       Assert.assertEquals(rowsValue.get(2).getText(),genderValue);

        Assert.assertEquals(rowsLabel.get(3).getText(),"Mobile");
        Assert.assertEquals(rowsValue.get(3).getText(),mobilValue);

        Assert.assertEquals(rowsLabel.get(4).getText(),"Date of Birth");
        Assert.assertEquals(rowsValue.get(4).getText(),dobValue);

        Assert.assertEquals(rowsLabel.get(5).getText(),"Subjects");
        Assert.assertEquals(rowsValue.get(5).getText(),subjectsValue);

        Assert.assertEquals(rowsLabel.get(6).getText(),"Hobbies");
        for (String hobby : hobbiesAdd) {
            Assert.assertTrue(rowsValue.get(6).getText().contains(hobby));
        }

        Assert.assertEquals(rowsLabel.get(7).getText(),"Picture");
        String[] arrayFileName = locatiePoza.split("\\\\");
        Integer desireIndex = arrayFileName.length -1;
        Assert.assertEquals(rowsValue.get(7).getText(),arrayFileName[desireIndex]);

        Assert.assertEquals(rowsLabel.get(8).getText(),"Address");
        Assert.assertEquals(rowsValue.get(8).getText(),addressValue);

        Assert.assertEquals(rowsLabel.get(9).getText(),"State and City");
        Assert.assertEquals(rowsValue.get(9).getText(),stateValue + " "+cityValue);
//CLOSE SUBMIT AND REFRESH
        WebElement closeButton = webDriver.findElement(By.id("closeLargeModal"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", closeButton);
        closeButton.click();
        webDriver.navigate().refresh();
    }
}