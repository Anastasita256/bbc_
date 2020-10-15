package Task3.Tests;

import Task3.Pages.BasePage;
import Task3.Pages.FormPage;
import Task3.Pages.HomePage;
import Task3.Pages.NewsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;
    private static final String BBC_URL = "https://www.bbc.com";



    @BeforeClass
    public void testsSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    @BeforeMethod
    public void openHomePage(){
        driver.get(BBC_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

   
    public BasePage getBasePage() {
        return new BasePage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public FormPage getFormPage() {
        return new FormPage(driver);
    }
}
