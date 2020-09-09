import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://www.bbc.com");
    }

    @Test(
            priority = 4
    )
    public void submitNewsWithOutRequiredCheckBoxClick() {
        this.driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(this.driver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sign_in-container']")));
        this.driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        this.driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        this.driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        this.driver.findElement(By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]]")).click();
        this.driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys(new CharSequence[]{"Hello"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys(new CharSequence[]{"Anastasiia"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys(new CharSequence[]{"Anastasiia"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys(new CharSequence[]{"Ukraine"});
        this.driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        this.driver.findElement(By.xpath("//button[@class='button']")).click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("news"));
    }

    @Test(
            priority = 5
    )
    public void submitNewsWithInvalidEmail() {
        this.driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(this.driver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sign_in-container']")));
        this.driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        this.driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        this.driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        this.driver.findElement(By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
        this.driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys(new CharSequence[]{"Hello"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys(new CharSequence[]{"Anastasiia"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys(new CharSequence[]{"1234rty"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys(new CharSequence[]{"345678"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys(new CharSequence[]{"Ukraine"});
        this.driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]")).click();
        this.driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        this.driver.findElement(By.xpath("//button[@class='button']")).click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("news"));
    }

    @Test(
            priority = 6
    )
    public void submitNewsWithEmptyTextBox() {
        this.driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        WebDriverWait wait = new WebDriverWait(this.driver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sign_in-container']")));
        this.driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        this.driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        this.driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        this.driver.findElement(By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys(new CharSequence[]{"Anastasiia"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys(new CharSequence[]{"1234rty@mail.ru"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys(new CharSequence[]{"345678"});
        this.driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys(new CharSequence[]{"Ukraine"});
        this.driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]")).click();
        this.driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        this.driver.findElement(By.xpath("//button[@class='button']")).click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("news"));

          }

    @AfterMethod
    public void tearDown() {
        this.driver.close();
    }
}
