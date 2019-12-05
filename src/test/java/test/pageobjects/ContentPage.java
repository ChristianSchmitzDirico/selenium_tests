package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.pageobjects.core.CoreMethods;

public class ContentPage extends CoreMethods {

    //Webelements
    private By sideBarBtnInspiration = By.xpath("//div[@title='Inspiration']");
    private By btnInspirationSettings = By.xpath("//a[contains(@aria-label, 'navigate to inspirations')]");
    private By btnInspirationSearch = By.xpath("//button[contains(@aria-label, 'Search')]");
    private By inputInspirationSearch = By.name("searchText");
    private By inspirationItem = By.xpath("//*[contains(text(),'Marvel')]");
    public ContentPage(WebDriver driver) {
        super(driver);
    }
}
