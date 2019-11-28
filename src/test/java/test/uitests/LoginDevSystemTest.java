package test.uitests;

import core.drivermanager.DriverType;
import core.drivermanager.DriverManager;
import core.drivermanager.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import core.utils.ElementHelper;

//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;


public class LoginDevSystemTest {

    private DriverManager driverManager;
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.EDGE);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.SAFARI);
    }

    @BeforeMethod
    public void setUp() {
        driver = driverManager.getWebDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitWebDriver();
    }

    @Test
    public void loginPageTest() {
        driver.get("https://c3-dev-login.azurewebsites.net");
        ElementHelper.findElementWithDelay(driver, By.name("username")).click();
        ElementHelper.findElementWithDelay(driver, By.name("username")).sendKeys("christian.schmitz@dirico.io");
        {
            Actions builder = new Actions((WebDriver) driver);
            builder
                    .moveToElement(ElementHelper.findElementWithDelay(driver, By.cssSelector(".jss290 > .jss268")))
                    .perform();
        }
        driver.findElement(By.name("Password")).sendKeys("Il@yda1993");
        driver.findElement(By.cssSelector(".jss290 > .jss268")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            Actions builder = new Actions(driver);
            builder.moveToElement(ElementHelper.findElementWithDelay(driver, By.cssSelector(".MuiListItem-selected-138")))
                    .perform();

        }
        {
            Actions builder = new Actions(driver);
            builder.moveToElement(ElementHelper.findElementWithDelay(driver, By.tagName("body")), 0, 0)
                    .perform();
        }
//        assertThat(driver.findElement(By.cssSelector(".user-menu-button > .md-caption")).getText(), is("Christian"));
//        assertThat(driver.getTitle(), is("dirico.io - Dashboard"));
    }
}