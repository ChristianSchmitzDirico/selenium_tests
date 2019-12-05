package core.testtemplate;

import core.drivermanager.DriverManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

@Data
public class BaseTest {

    private DriverManager driverManager;
    private WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        driver = driverManager.getWebDriver();//Maximize Window
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void teardown() {
        driverManager.quitWebDriver();
    }
}
