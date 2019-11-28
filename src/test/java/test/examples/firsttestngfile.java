package test.examples;

import core.drivermanager.DriverType;
import core.drivermanager.DriverManager;
import core.drivermanager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firsttestngfile {

    private WebDriver driver;
    private DriverManager driverManager;

    @Test
    public void verifyHomepageTitle() {

        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
