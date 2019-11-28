package test.base;

import core.drivermanager.DriverManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Data
public class BaseConfig {

    private DriverManager driverManager;
    private WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        driver = driverManager.getWebDriver();//Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driverManager.quitWebDriver();
    }
}
