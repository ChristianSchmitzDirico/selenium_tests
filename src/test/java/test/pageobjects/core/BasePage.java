package test.pageobjects.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitClickability(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void waitPresence(By elementBy) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Click Method
    public void clickWithEscape(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
        driver.findElement(elementBy).sendKeys(Keys.ESCAPE);
    }

    //Click Method
    public void clickableClick(By elementBy) {
        waitClickability(elementBy);
        driver.findElement(elementBy).click();
    }

    //Click Method
    public void presentClick(By elementBy) {
        waitPresence(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Write Text
    public void writeTextWithEscape(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
        driver.findElement(elementBy).sendKeys(Keys.ESCAPE);
    }

    //Write Text
    public void clickableWriteText(By elementBy, String text) {
        waitClickability(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Write Text
    public void presentWriteText(By elementBy, String text) {
        waitPresence(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void pressKey(Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }
}
