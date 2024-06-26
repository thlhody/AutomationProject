package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {
    public FormsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormElem;

    public void navigateToPracticeForm() {
        elementMethods.clickElem(practiceFormElem);
        LoggerUtility.infoTest("User navigates to Practice Form");
    }
}
