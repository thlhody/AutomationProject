package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{
    public FramePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "sampleHeading")
    private WebElement textFrame;

    public void dealWithIFrame(){

        frameMethods.switchSpecifcIframe("frame1");
        frameMethods.switchParentFrame();
        frameMethods.switchSpecifcIframe("frame2");

    }
}
