package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {
    public FramePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement textFrame;

    public void dealWithIFrame() {

        frameMethods.switchSpecifcIframe("frame1");
        LoggerUtility.infoTest("User selects Frame 1");
        frameMethods.switchParentFrame();
        LoggerUtility.infoTest("User switches to parent frame");
        frameMethods.switchSpecifcIframe("frame2");
        LoggerUtility.infoTest("User selects Frame 2");

    }
}
