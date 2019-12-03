package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.BasePage;

public class DashboardPage extends BasePage {

    //Webelements
    private By btnAddTask = By.xpath("//button[contains(@aria-label, 'New task')]");
    private By btnSaveTask = By.xpath("//button[contains(@aria-label, 'save task')]");
    private By textFieldTitle = By.xpath("//input[@name='title']");
    private By textFieldAssignTo = By.xpath("//input[@name='assignedUserIds']");
    private By fieldAssignToDropDown = By.cssSelector("#downshift-1-item-0 .MuiTypography-root-161");
    private By fieldAssignToValue = (By.xpath("//span[contains(text(),'Christian Schmitz')]"));
    private By createdTaskTitle = By.xpath("/html[1]/body[1]/app-cmp[1]/div[1]/div[1]/div[1]/ng-outlet[1]/dashboard[1]/ng-outlet[1]/main-dashboard[1]/div[1]/div[1]/ng-include[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/table-widget-base-react[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //PageMethods
    public DashboardPage createTask(String taskTitle, String userName) {
        clickableClick(btnAddTask);
        writeText(textFieldTitle, taskTitle);
        writeText(textFieldAssignTo, userName);
        click(fieldAssignToDropDown);
        waitVisibility(fieldAssignToValue);
        pressKey(Keys.ESCAPE);
        clickableClick(btnSaveTask);
        return this;
    }

    public void checkTask(String expectedTaskTitle) {
        assertEquals(createdTaskTitle, expectedTaskTitle);
    }

    public DashboardPage createContent() {
        return this;
    }

    public DashboardPage requestApproval() {
        return this;
    }
}
