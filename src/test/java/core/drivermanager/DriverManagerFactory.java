package core.drivermanager;

import core.drivermanager.browser.ChromeDriverManager;
import core.drivermanager.browser.EdgeDriverManager;
import core.drivermanager.browser.FireFoxDriverManager;
import core.drivermanager.browser.SafariDriverManager;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
