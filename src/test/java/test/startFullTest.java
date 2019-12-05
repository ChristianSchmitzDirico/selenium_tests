package test;

import core.drivermanager.DriverManagerFactory;
import core.drivermanager.DriverType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.base.BaseTest;
import test.pageobjects.DashboardPage;
import test.pageobjects.InspirationPage;
import test.pageobjects.LoginPage;

@EqualsAndHashCode(callSuper = true)
@Data
public class startFullTest extends BaseTest {

    @BeforeSuite
    public void setBrowserDriverType() {
        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.CHROME));
//        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.FIREFOX));
    }

    @Test(priority = 1, testName = "#1 Login")
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

//        @Test(priority = 2, testName = "#2 Dashboard: Task")
    public void createTaskTest() {

        //*************PAGE INSTANTIATIONS*************
        DashboardPage dashboardPage = new DashboardPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        dashboardPage
                .createTask("TestTask", "Christian Schmitz")
                .checkTask("TestTask")
        ;
    }

//        @Test(priority = 3, testName = "#2 Dashboard: Approval")
    public void createApprovalTest() {

        //*************PAGE INSTANTIATIONS*************
        DashboardPage dashboardPage = new DashboardPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        dashboardPage
                .createContent()
        ;
    }

    @Test(priority = 4, testName = "#3 Test: Inspiration")
    public void createInspirationTest() {

        //*************PAGE INSTANTIATIONS*************
        InspirationPage inspirationPage = new InspirationPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        inspirationPage
                .createIspiration()
                .checkInspiration("Marvel Entertainment");
    }
}

