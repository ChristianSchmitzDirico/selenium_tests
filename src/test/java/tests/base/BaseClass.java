package tests.base;

import common.DriverType;
import common.WebDriverFacade;
import lombok.Data;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

@Data
public class BaseClass {

    private WebDriverFacade webDriver;
    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        // This method gets invoked if the test fails for any reason:
        @Override
        protected void failed(Throwable e, Description description) {
            // Print out the error message:
            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            // Now you can do whatever you need to do with it, for example take a screenshot
            File scrFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                File currPath = new File(new JFileChooser().getCurrentDirectory().toString() + "\\screenshot.png");
                System.out.println("Screenshot at: " + currPath.toString());
                FileHandler.copy(scrFile, currPath);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        // This method gets called when the test finishes, regardless of status
        // If the test fails, this will be called after the method above
        @Override
        protected void finished(Description description) {
            if (getWebDriver() != null) {
                getWebDriver().Stop();
            }
        }
    };

    @Before
    public void setUp(DriverType browser) throws Exception {
//        String driverExecutablePath = "./src/main/java/resources/chromedriver78.exe";
//        System.setProperty("webdriver.chrome.driver", new File(driverExecutablePath).getCanonicalPath());
//        driver = new ChromeDriver(setChromeOptions());
//        driver.get("https://c3-dev-login.azurewebsites.net");
        webDriver = new WebDriverFacade(browser);

    }

    public void setBrowserType(DriverType browser) throws Exception {
        setUp(browser);
    }
}
