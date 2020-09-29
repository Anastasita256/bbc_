package Task3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    //private static final By SEARCH_INPUT = By.xpath("//input[@id='input_search']");
    private static final By NEWS_BUTTON = By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]");
    //private static final By APPLE_STORE_BUTTON = By.xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]");
    //private static final By AMOUNT_OF_PRODUCTS_IN_CART = By.xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
/*
    public void searchByKeyword(final String keyword) {
        driver.findElement(SEARCH_INPUT).sendKeys(keyword, Keys.ENTER);
    }
*/

    public void clickOnNews() {
        driver.findElement(NEWS_BUTTON).click();
    }
/*
    public void clickOnAppleStoreButton() {
        driver.findElement(APPLE_STORE_BUTTON).click();
    }

    public String getTextOfAmountProductsInCart() {
        return driver.findElement(AMOUNT_OF_PRODUCTS_IN_CART).getText();
    }
*/

}
