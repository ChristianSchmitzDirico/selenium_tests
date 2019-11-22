package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class firsttestngfile {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver;
    //    String driverPath = "C:\\geckodriver.exe";
    String driverExecutablePath = "./src/main/java/resources/driver/chrome/chromedriver78.exe";

    @Test
    public void verifyHomepageTitle() {

        System.out.println("launching firefox browser");
//        System.setProperty("webdriver.firefox.marionette", driverPath);
        try {
            System.setProperty("webdriver.chrome.driver", new File(driverExecutablePath).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
