package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.BasePage;

public class LoginPage extends BasePage {

    //Webelements
    private By usernameBy = By.name("username");
    private By passwordBy = By.name("Password");
//    private By loginButtonBy = By.cssSelector(".jss290 > .jss268");
    private By loginButtonBy = By.xpath("//div[@class='MuiCardActions-root-271']//div[1]//div[1]");
//    private By titleUsernameBy = By.cssSelector(".user-menu-button > .md-caption");
    private By titleUsernameBy = By.xpath("//span[@class='md-caption hide-xs ng-binding ng-scope'][contains(text(),'Christian')]");
//    private By pageTitleBy = By.name("/dirico.io - Dashboard");
    private By pageTitleBy = By.xpath("/html[1]/body[1]/app-cmp[1]/div[1]/div[1]/div[1]/ng-outlet[1]/dashboard[1]/md-toolbar[1]/div[1]/h2[1]");

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

    public LoginPage verifyLogin(String expectedText1, String expectedText2) {
        assertEquals(titleUsernameBy, expectedText1);
        assertEquals(pageTitleBy, expectedText2);
        return this;
    }

}
