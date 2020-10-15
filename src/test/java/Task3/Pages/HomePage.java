package Task3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
   
    private static final By NEWS_BUTTON = By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]");
    

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnNews() {
        driver.findElement(NEWS_BUTTON).click();
        return this;
    }
}
