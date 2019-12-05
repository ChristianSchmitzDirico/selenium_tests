package test.tests.subtests;

import core.drivermanager.DriverManagerFactory;
import core.drivermanager.DriverType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import core.testtemplate.BaseTest;
import test.pageobjects.LoginPage;

public class LoginTest extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.CHROME));
    }

    @Test()
    public void loginTest() {

        //*************PAGE INSTANTIATIONS*************
        LoginPage page = new LoginPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        getDriver().get("https://c3-dev-login.azurewebsites.net");
//        getDriver().get("https://app.dirico.io/");
        page.login2Dirico("christian.schmitz@dirico.io", "Il@yda1993")
                .verifyLogin("Dashboard")
        ;
    }
}
