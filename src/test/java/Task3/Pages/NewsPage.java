package Task3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPage extends BasePage{

    private static final By POPUP = By.xpath("//div[@class='sign_in-container']");
    private static final By CLOSEPOPUP = By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']");
    private static final By SEARCH_RESULTS_LIST_TEXT = By.xpath("//div[@class='gel-wrap gs-u-pt+']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']");
    private static final By CORONAVIRUSTAB = By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]");
    private static final By STORY = By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]");
    private static final By SHARE = By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]]");

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public By getPopup() {
        return POPUP;
    }

    public void clickOnClosePopup() {
        driver.findElement(CLOSEPOPUP).click();
    }

    public int getNewsCount() {
        return getNewsList().size();
    }
    public List<WebElement> getNewsList() {
        return driver.findElements(SEARCH_RESULTS_LIST_TEXT);
    }

    public void clickOnCoronavirusTab() {
        driver.findElement(CORONAVIRUSTAB).click();
    }

    public void clickYourStory() {
        driver.findElement(STORY).click();
    }

    public void clickOnShare() {
        driver.findElement(SHARE).click();
    }


}
