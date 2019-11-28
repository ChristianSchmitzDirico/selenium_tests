package test.uitests;

import core.drivermanager.DriverManager;
import core.drivermanager.DriverManagerFactory;
import core.drivermanager.DriverType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.base.BaseConfig;
import test.pageobjects.LoginPage;

public class DevSystemLoginTest extends BaseConfig {
    @Override
    public void setDriverManager(DriverManager driverManager) {
        super.setDriverManager(driverManager);
    }

    @Override
    public DriverManager getDriverManager() {
        return super.getDriverManager();
    }

    @BeforeTest
    public void beforeTest() {
        setDriverManager(DriverManagerFactory.getDriverManager(DriverType.CHROME));
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.EDGE);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.SAFARI);

    }

    @Test(priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {

        //*************PAGE INSTANTIATIONS*************
        LoginPage page = new LoginPage(getDriverManager().getWebDriver());

        //*************PAGE METHODS********************
        getDriver().get("https://c3-dev-login.azurewebsites.net");
        page.login2Dirico("christian.schmitz@dirico.io", "Il@yda1993")
                .verifyLogin("Christian1", "Dashboard1")
        ;
    }
}
