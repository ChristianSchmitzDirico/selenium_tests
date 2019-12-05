package core.drivermanager;

import core.drivermanager.browsermanager.ChromeDriverManager;
import core.drivermanager.browsermanager.EdgeDriverManager;
import core.drivermanager.browsermanager.FireFoxDriverManager;
import core.drivermanager.browsermanager.SafariDriverManager;

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
