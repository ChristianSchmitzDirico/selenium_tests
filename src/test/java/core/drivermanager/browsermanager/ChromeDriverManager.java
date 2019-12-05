package core.drivermanager.browsermanager;

import core.drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    private ChromeOptions options;

    @Override
    protected void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "disable-infobars",
                "--disable-notifications",
                "--lang=de_DE");
        this.driver = new ChromeDriver(options);
    }


}
