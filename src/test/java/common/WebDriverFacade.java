package common;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public class WebDriverFacade {
    private WebDriver webDriver = null;
    private Duration waitForElement = Duration.ofSeconds(5);

    public WebDriverFacade(DriverType browser) {
        WebDriverFactory factory = new WebDriverFactory();
        webDriver = factory.CreateInstance(browser);
    }

    public void Start(String url) {
        webDriver.get(url);
    }

    public void Stop() {
        webDriver.quit();
    }

//    public object ExecuteJavaScript(string script)
//    {
//        return ((IJavaScriptExecutor)webDriver).
//                ExecuteScript("return " + script);
//    }

    public WebElement FindElement(By by) {
        try {


            return new WebDriverWait(getWebDriver(), getWaitForElement().getSeconds())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            return null;
        }
    }
}
