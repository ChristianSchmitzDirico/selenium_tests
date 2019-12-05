package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.BasePage;

public class InspirationPage extends BasePage {

//    Inspiration
//    Click on Settings -> Click on "+" upper right - done
//    Search for something and add it - done
//    Check in Inspirations if Items from new feed appear - done
    //TODO
//    Click on Item -> Source opens?
//    Click on "Create Idea out of this article", check if New Idea Page opens and go back
//    Click on "Create Content out of this article", select Content, check if New Content Page opens and go back
//    Check Search
//    Check CSV Download
//    Set Filter to "This Week" and check if older Items appear
//    Settings -> Give new Feed a new Title -> Save
//    Delete new Feed

    //Webelements
    private By sideBarBtnInspiration = By.xpath("//div[@title='Inspiration']");
    private By btnInspirationSettings = By.xpath("//a[contains(@aria-label, 'navigate to inspirations')]");
    private By btnInspirationSearch = By.xpath("//button[contains(@aria-label, 'Search')]");
    private By inputInspirationSearch = By.name("searchText");
    private By inspirationItem = By.xpath("//*[contains(text(),'Marvel')]");


    public InspirationPage(WebDriver driver) {
        super(driver);
    }

    //PageMethods
    public InspirationPage createIspiration() {
        clickableClick(sideBarBtnInspiration);
        click(btnInspirationSettings);
        click(btnInspirationSearch);
        writeText(inputInspirationSearch, "Marvel");
        return this;
    }

    public void checkInspiration(String expectedInspirationTitle) {
        assertEquals(inspirationItem, expectedInspirationTitle);

    }
}
