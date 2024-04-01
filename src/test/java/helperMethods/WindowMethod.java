package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethod {
    private WebDriver webDriver;

    public WindowMethod(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchSpecificTabWindow(Integer index) {

        List<String> tabWindow = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabWindow.get(index));
        //System.out.println("Tabul/Window curent este "+webDriver.getCurrentUrl());
    }

    public void closeCurrentTabWindow() {
        webDriver.close();
    }
}
