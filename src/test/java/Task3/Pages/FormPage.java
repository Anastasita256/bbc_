package Task3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage{

    private static final By NAME_INPUT = By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']");
    private static final By CONTACT_INPUT = By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']");
    private static final By LOCATION_INPUT = By.xpath("//div[@class='text-input']//input[@placeholder='Location ']");
    private static final By ACCEPT = By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]");
    private static final By BUTTON = By.xpath("//button[@class='button']");
    private static final By EMAIL_INPUT = By.xpath("//div[@class='text-input']//input[@placeholder='Email address']");
    private static final By YEAR = By.xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]");
    private static final By TEXT = By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void nameInput(final String keyword) {
        driver.findElement(NAME_INPUT).sendKeys(keyword, Keys.ENTER);
    }

    public void contactInput(final String keyword) {
        driver.findElement(CONTACT_INPUT).sendKeys(keyword, Keys.ENTER);
    }

    public void location(final String keyword) {
        driver.findElement(LOCATION_INPUT).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnAcceptions() {
        driver.findElement(ACCEPT).click();
    }

    public void clickOnSendButton() {
        driver.findElement(BUTTON).click();
    }

    public void email(final String keyword) {
        driver.findElement(EMAIL_INPUT).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnYear() {
        driver.findElement(YEAR).click();
    }

    public void textarea(final String keyword) {
        driver.findElement(TEXT).sendKeys(keyword, Keys.ENTER);
    }
}
