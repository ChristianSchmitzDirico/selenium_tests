package core.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

    public static WebElement findElementWithDelay(WebDriver driver, By locator) {
        return (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
