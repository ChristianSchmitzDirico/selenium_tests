package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.BasePage;

public class DashboardPage extends BasePage {

//    Dashboard
//    Create a task and assign it to you with the "+" button on dashboard - done
//    Check if the task is displayed in dashboard at my tasks - done
    //TODO
//    Go to a content and request an approval and set your name as mandatory
//    Check if the approval is displayed in the dashboard
//    Click on one content of each category and check if the link is working

    //Webelements
    private By btnAddTask = By.xpath("//button[contains(@aria-label, 'New task')]");
    private By btnSaveTask = By.xpath("//button[contains(@aria-label, 'save task')]");
    private By textFieldTitle = By.xpath("//input[@name='title']");
    private By textFieldAssignTo = By.xpath("//input[@name='assignedUserIds']");
    private By fieldAssignToDropDown = By.cssSelector("#downshift-1-item-0 .MuiTypography-root-161");
    private By fieldAssignToValue = (By.xpath("//span[contains(text(),'Christian Schmitz')]"));
    private By createdTaskTitle = By.xpath("//div[contains(text(),'TestTask')]");
    private By addContentTile = By.xpath("//span[contains(text(),'Add content')]");


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
        click(addContentTile);
        return this;
    }

    public DashboardPage requestApproval() {
        return this;
    }
}
