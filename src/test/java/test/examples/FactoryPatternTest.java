package test.examples;

import core.drivermanager.DriverType;
import core.drivermanager.DriverManager;
import core.drivermanager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FactoryPatternTest {
    private DriverManager driverManager;
    private WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.EDGE);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getWebDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitWebDriver();
    }

    @Test
    public void launchTestAutomationGuruTest() {
        driver.get("http://testautomationguru.com");
        Assert.assertEquals("TestAutomationGuru – A technical blog on test automation", driver.getTitle());
    }

    @Test
    public void launchGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void launchYahooTest() {
        driver.get("https://www.yahoo.com");
        Assert.assertEquals("Yahoo", driver.getTitle());

    }
}
