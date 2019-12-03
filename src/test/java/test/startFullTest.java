package test;

import core.drivermanager.DriverManagerFactory;
import core.drivermanager.DriverType;
import lombok.Data;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.base.BaseTest;
import test.pageobjects.DashboardPage;
import test.pageobjects.LoginPage;

@Data
public class startFullTest extends BaseTest {

//    private DriverManager driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
//    private WebDriver driver = driverManager.getWebDriver();


    @BeforeSuite
    public void setBrowserDriverType() {
        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.CHROME));
//        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.FIREFOX));
    }

    @Test(priority = 1, testName = "#1 Test: Login")
    public void loginTest() {

        //*************PAGE INSTANTIATIONS*************
        LoginPage loginPage = new LoginPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        getDriver().get("https://c3-dev-login.azurewebsites.net");
//        getDriver().get("https://app.dirico.io/");
        loginPage.login2Dirico("christian.schmitz@dirico.io", "Il@yda1993")
                .verifyLogin("Dashboard")
        ;
    }

    @Test(priority = 2, testName = "#2 Test: Dashboard")
    public void createTaskTest() {

        //*************PAGE INSTANTIATIONS*************
        DashboardPage dashboardPage = new DashboardPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        dashboardPage
                .createTask("TestTask", "Christian Schmitz")
                .checkTask("TestTask")
        ;
    }

//    @AfterClass
//    public void teardown() {
//        driverManager.quitWebDriver();
//    }
}

