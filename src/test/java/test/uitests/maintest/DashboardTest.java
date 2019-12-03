package test.uitests.maintest;

import core.drivermanager.DriverManagerFactory;
import core.drivermanager.DriverType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.base.BaseTest;
import test.pageobjects.DashboardPage;

public class DashboardTest extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.CHROME));
    }

    @Test(priority = 0)
    public void createTaskTest() {

        //*************PAGE INSTANTIATIONS*************
        DashboardPage page = new DashboardPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        page
                .createTask("TestTask", "Christian Schmitz")
                .checkTask("TestTask")
        ;
    }
}
