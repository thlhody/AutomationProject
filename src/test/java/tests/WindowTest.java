package tests;

import helperMethods.ElementMethods;
import helperMethods.WindowMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods  = new ElementMethods(getWebDriver());
        WindowMethod windowMethod = new WindowMethod(getWebDriver());

        elementMethods.scrollElemByPixel(0,450);
//intram pe pagina Browser window
        WebElement alertWindowFrameElem = getWebDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElem(alertWindowFrameElem);
        WebElement browserWindows = getWebDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickElem(browserWindows);
//tab
        System.out.println("Tab curent 1 este "+getWebDriver().getCurrentUrl());
        WebElement newTabButton = getWebDriver().findElement(By.id("tabButton"));
        elementMethods.clickElem(newTabButton);
        windowMethod.switchSpecificTabWindow(1);//sample window
        System.out.println("Tab curent 2 este "+getWebDriver().getCurrentUrl());
        windowMethod.closeCurrentTabWindow();
        windowMethod.switchSpecificTabWindow(0);//browser window
//window
        System.out.println("Window curent 1 este "+getWebDriver().getCurrentUrl());
        WebElement newWindowButton = getWebDriver().findElement(By.id("windowButton"));
        elementMethods.clickElem(newWindowButton);
        windowMethod.switchSpecificTabWindow(1);//sample window
        System.out.println("Window curent 2 este "+getWebDriver().getCurrentUrl());
        windowMethod.closeCurrentTabWindow();
        windowMethod.switchSpecificTabWindow(0);//browser window
//window mesage
        System.out.println("Tab curent este "+getWebDriver().getCurrentUrl());
        WebElement newWindowMsgButton = getWebDriver().findElement(By.id("messageWindowButton"));
        elementMethods.clickElem(newWindowMsgButton);
        windowMethod.switchSpecificTabWindow(1);//sample window
        System.out.println("window mesaj curent este un mesaj ");
        windowMethod.closeCurrentTabWindow();
        windowMethod.switchSpecificTabWindow(0);//browser window
    }
}
