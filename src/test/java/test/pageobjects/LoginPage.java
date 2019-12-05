package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.CoreMethods;

/**
 *
 */
public class LoginPage extends CoreMethods {

    //Webelements
    private By usernameBy = By.name("username");
    private By passwordBy = By.name("Password");
    private By loginButtonBy = By.name("button");
    private By pageTitleBy = By.xpath("//h2[contains(text(),'Dashboard')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //PageMethods
    public LoginPage login2Dirico(String username, String password) {
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public void verifyLogin(String expectedText1) {
        assertEquals(pageTitleBy, expectedText1);
    }

}
