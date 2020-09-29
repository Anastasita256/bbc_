import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Task1 {

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
    public void findHeadLineArticle() {
        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        waiter();
        driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        String actualMessage = this.driver.findElement(By.xpath("//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']//h3[contains(text(),\"US city police chiefs quit after 'spit hood' death\")]")).getText();

        Assert.assertEquals(actualMessage, "US city police chiefs quit after 'spit hood' death","Header is correct");
    }

    @Test
    public void checkSecondaryArticleTitles() {
        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        waiter();
        driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        List<WebElement> elementList = this.driver.findElements(By.xpath("//div[@class='gel-wrap gs-u-pt+']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']"));
        int actualElementsSize = elementList.size();

        Assert.assertEquals(actualElementsSize, 15);
    }

    @Test
    public void checkFirstArticleName() {
        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(@href,'news')]")).click();
        waiter();
        driver.findElement(By.xpath("//div[@class='sign_in-container']//button[@class='sign_in-exit']")).click();
        String actualMessage = this.driver.findElement(By.xpath("//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']//h3[contains(text(),\"US city police chiefs quit after 'spit hood' death\")]")).getText();
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(new CharSequence[]{actualMessage, Keys.ENTER});

        Assert.assertEquals(actualMessage, "US city police chiefs quit after 'spit hood' death","Header is correct");
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
