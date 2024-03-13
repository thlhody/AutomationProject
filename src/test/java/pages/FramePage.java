package pages;

import org.openqa.selenium.By;
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
        elementMethods.printElemText(textFrame);
        frameMethods.switchParentFrame();
        frameMethods.switchSpecifcIframe("frame2");
        elementMethods.printElemText(textFrame);

    }
}
