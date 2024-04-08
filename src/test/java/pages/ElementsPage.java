package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webElementField;

    public void navigateToWebTablePage() {
        webElementField.click();
        LoggerUtility.infoTest("User Navigate to Web Table Page");
    }
}
