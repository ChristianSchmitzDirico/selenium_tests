//package tests.testparts;
//
//import common.DriverType;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import tests.base.BaseClass;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//
//public class LoginDevSystemTest extends BaseClass {
//
////    private WebDriver driver;
//
////    @Rule
////    public final TestRule watchman = new TestWatcher() {
////        @Override
////        public Statement apply(Statement base, Description description) {
////            return super.apply(base, description);
////        }
////
////        // This method gets invoked if the test fails for any reason:
////        @Override
////        protected void failed(Throwable e, Description description) {
////            // Print out the error message:
////            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
////            // Now you can do whatever you need to do with it, for example take a screenshot
////            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////            try {
////                File currPath = new File(new JFileChooser().getCurrentDirectory().toString() + "\\screenshot.png");
////                System.out.println("Screenshot at: " + currPath.toString());
////                FileHandler.copy(scrFile, currPath);
////            } catch (IOException e1) {
////                e1.printStackTrace();
////            }
////        }
////
////        // This method gets called when the test finishes, regardless of status
////        // If the test fails, this will be called after the method above
////        @Override
////        protected void finished(Description description) {
////            if (driver != null) {
////                driver.quit();
////            }
////        }
////    };
//
////    @Before
////    public void setUp() throws Exception {
////        String driverExecutablePath = "./src/main/java/resources/chromedriver78.exe";
////        System.setProperty("webdriver.chrome.driver", new File(driverExecutablePath).getCanonicalPath());
////        driver = new ChromeDriver(setChromeOptions());
////        driver.get("https://c3-dev-login.azurewebsites.net");
////    }
//
//    @Test
//    public void loginPageTest() throws Exception {
//        setBrowserType(DriverType.Chrome);
//        findElementWithDelay(By.name("username")).click();
//        findElementWithDelay(By.name("username")).sendKeys("christian.schmitz@dirico.io");
//        {
//            Actions builder = new Actions((WebDriver) getWebDriver());
//            builder
//                    .moveToElement(findElementWithDelay(By.cssSelector(".jss290 > .jss268")))
//                    .perform();
//        }
//        driver.findElement(By.name("Password")).sendKeys("Il@yda1993");
//        driver.findElement(By.cssSelector(".jss290 > .jss268")).click();
//        {
//            WebElement element = driver.findElement(By.tagName("body"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element, 0, 0).perform();
//        }
//        {
//            Actions builder = new Actions(driver);
//            builder.moveToElement(findElementWithDelay(By.cssSelector(".MuiListItem-selected-138")))
//                    .perform();
//
//        }
//        {
//            Actions builder = new Actions(driver);
//            builder.moveToElement(findElementWithDelay(By.tagName("body")), 0, 0)
//                    .perform();
//        }
//        assertThat(driver.findElement(By.cssSelector(".user-menu-button > .md-caption")).getText(), is("Christian"));
//        assertThat(driver.getTitle(), is("dirico.io - Dashboard"));
//    }
//
//    private ChromeOptions setChromeOptions() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("disable-infobars");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--lang=de_DE");
//        return options;
//    }
//
//    private WebElement findElementWithDelay(By locator) {
//        return (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
//
////    @Rule
////    public void addRule() {
////        final TestRule watchman = new TestWatcher() {
////            @Override
////            public Statement apply(Statement base, Description description) {
////                return super.apply(base, description);
////            }
////
////            // This method gets invoked if the test fails for any reason:
////            @Override
////            protected void failed(Throwable e, Description description) {
////                // Print out the error message:
////                System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
////                // Now you can do whatever you need to do with it, for example take a screenshot
////                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////                try {
////                    File currPath = new File(new JFileChooser().getCurrentDirectory().toString() + "\\screenshot.png");
////                    System.out.println("Screenshot at: " + currPath.toString());
////                    FileHandler.copy(scrFile, currPath);
////                } catch (IOException e1) {
////                    e1.printStackTrace();
////                }
////            }
////
////            // This method gets called when the test finishes, regardless of status
////            // If the test fails, this will be called after the method above
////            @Override
////            protected void finished(Description description) {
////                if (driver != null) {
////                    driver.quit();
////                }
////            }
////        };
////    }
//
//    @Override
//    public void setBrowserType(DriverType browser) throws Exception {
//        super.setBrowserType(browser);
//    }
//}