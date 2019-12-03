package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.BasePage;

public class InspirationPage extends BasePage {

    //Webelements
    private By sideBarBtnInspiration = By.xpath("//div[@title='Inspiration']");
    private By btnInspirationSettings = By.xpath("//a[contains(@aria-label, 'navigate to inspirations')]");
    private By btnInspirationSearch = By.xpath("//button[contains(@aria-label, 'Search')]");
    private By inputInspirationSearch = By.name("searchText");


    public InspirationPage(WebDriver driver) {
        super(driver);
    }

    //PageMethods
    public void createIspiration() {
        clickableClick(sideBarBtnInspiration);
        click(btnInspirationSettings);
        click(btnInspirationSearch);
        writeText(inputInspirationSearch, "Marvel");
    }
}
