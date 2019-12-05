package core.drivermanager.browsermanager;

import core.drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        this.driver = new EdgeDriver(options);
    }
}
