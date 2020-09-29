import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task2 {

    private WebDriver driver;

    @BeforeClass
    public void testsSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
        @BeforeMethod
    public void openHomePage() {
         this.driver.get("https://www.bbc.com");
    }

    @Test
    public void submitNewsWithOutRequiredCheckBoxClick() {
        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        waiter();
        driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        driver.findElement(By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]]")).click();
        driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys(new CharSequence[]{"Hello"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys(new CharSequence[]{"Anastasiia"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys(new CharSequence[]{"Anastasiia"});driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys(new CharSequence[]{"Ukraine"});
        driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("news"));
    }

    @Test
    public void submitNewsWithInvalidEmail() {
        this.driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        waiter();
        driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        driver.findElement(By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
        driver.findElement(By.xpath("//div[@class='embed-content-container']//textarea[@class='text-input--long']")).sendKeys(new CharSequence[]{"Hello"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys(new CharSequence[]{"Anastasiia"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys(new CharSequence[]{"1234rty"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys(new CharSequence[]{"345678"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys(new CharSequence[]{"Ukraine"});
        driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]")).click();
        driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("news"));
    }

    @Test
    public void submitNewsWithEmptyTextBox() {
        this.driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        waiter();
        driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(), 'Your Coronavirus Stories')]")).click();
        driver.findElement(By.xpath("//div[@class='nw-c-5-slice gel-layout gel-layout--equal b-pw-1280']//a[contains(@href,'10725415')]")).click();
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Name']")).sendKeys(new CharSequence[]{"Anastasiia"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Email address']")).sendKeys(new CharSequence[]{"1234rty@mail.ru"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Contact number ']")).sendKeys(new CharSequence[]{"345678"});
        driver.findElement(By.xpath("//div[@class='text-input']//input[@placeholder='Location ']")).sendKeys(new CharSequence[]{"Ukraine"});
        driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I am over 16 years old')]")).click();
        driver.findElement(By.xpath("//div[@class='checkbox']//p[contains(text(),'I accept the ')]")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("news"));

          }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void waiter() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sign_in-container']")));
    }
    }

