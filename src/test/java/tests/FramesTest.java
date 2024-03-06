package tests;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FramesTest extends SharedData {

    @Test
    public void metodaTest() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        FrameMethods frameMethods = new FrameMethods(getWebDriver());

// intram pe pagina Browser window
        WebElement alertWindowFrameElem = getWebDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElem(alertWindowFrameElem);
        WebElement framesElem = getWebDriver().findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickElem(framesElem);

        //interactiona cu un iframe
        frameMethods.switchSpecifcIframe("frame1");
        WebElement textFrame = getWebDriver().findElement(By.id("sampleHeading"));
        elementMethods.printElemText(textFrame);
        //specificam sa revina la framul curent

        frameMethods.switchParentFrame();
        frameMethods.switchSpecifcIframe("frame2");
        WebElement textFrameA = getWebDriver().findElement(By.id("sampleHeading"));
        elementMethods.printElemText(textFrameA);



    }
}