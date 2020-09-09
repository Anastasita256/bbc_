import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class bbc {

private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get("https://www.bbc.com");//открыли сайт
    }


    @Test(priority = 1)
    public void findHeadLineArticle() {
        driver.findElement(xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class='sign_in-container']")));
        driver.findElement(xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        String actualMessage =
                driver.findElement(xpath("//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']//h3[contains(text(),\"Iran's enriched uranium stockpile '10 times limit'\")]")).getText();
        assertEquals(actualMessage, "Iran's enriched uranium stockpile '10 times limit'");
    }

    @Test(priority = 2)
    public void checkSecondaryArticleTitles(){
        driver.findElement(xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class='sign_in-container']")));
        driver.findElement(xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='gel-wrap gs-u-pt+']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']"));//собрали элементы поиска в лист
        int actualElementsSize = elementList.size();//узнали количество элементов в листе
        assertEquals(actualElementsSize,15);
    }

    @Test(priority = 3)
    public void checkFirstArticleName(){
        driver.findElement(xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class='sign_in-container']")));
        driver.findElement(xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        String actualMessage =
                driver.findElement(xpath("//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']//h3[contains(text(),\"Iran's enriched uranium stockpile '10 times limit'\")]")).getText();

        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(actualMessage, Keys.ENTER);
        assertEquals(actualMessage, "Iran's enriched uranium stockpile '10 times limit'");
    }

    @Test(priority = 4)
    public void submitNewsWithOutCheckBoxClick() {
        driver.findElement(xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class='sign_in-container']")));
        driver.findElement(xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        driver.findElement(xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        driver.findElement(xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
        driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys("Hello");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys("Anastasiia");
        //driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys();
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys("Anastasiia");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys("Ukraine");
        driver.findElement(xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        driver.findElement(xpath("//button[@class='button']")).click();
        assertTrue(driver.getCurrentUrl().contains("news"));

    }

    @Test(priority = 5)
    public void submitNewsWithInvalidEmail() {
        driver.findElement(xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class='sign_in-container']")));
        driver.findElement(xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        driver.findElement(xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        driver.findElement(xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
        driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys("Hello");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys("Anastasiia");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys("1234rty");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys("345678");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys("Ukraine");
        driver.findElement(xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]")).click();
        driver.findElement(xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        driver.findElement(xpath("//button[@class='button']")).click();
        assertTrue(driver.getCurrentUrl().contains("news"));
    }
    @Test(priority = 6)
    public void submitNewsWithEmptyTextBox() {
        driver.findElement(xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@class='sign_in-container']")));
        driver.findElement(xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        driver.findElement(xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        driver.findElement(xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
    //    driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys("Hello");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys("Anastasiia");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys("1234rty");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys("345678");
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys("Ukraine");
        driver.findElement(xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]")).click();
        driver.findElement(xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        driver.findElement(xpath("//button[@class='button']")).click();
        assertTrue(driver.getCurrentUrl().contains("news"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
