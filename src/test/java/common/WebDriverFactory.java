package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public WebDriver CreateInstance(DriverType browser) {

        if (DriverType.Chrome == browser) {
            return new ChromeDriver();
        } else if (DriverType.Edge == browser) {
            return new EdgeDriver();
        } else if (DriverType.Firefox == browser) {
            return new FirefoxDriver();
        } else {
            return new SafariDriver();
        }
    }
}
