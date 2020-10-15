package Task3.Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchHeaderTests extends BaseTest{
     private final String EXPECTED_MESSAGE = "US city police chiefs quit after 'spit hood' death";
   
     @Test
    public void checkSecondaryArticleTitles() {
        getHomePage().clickOnNews();
        getHomePage().waitVisibilityOfPopup(30, getNewsPage().getPopup());
        getNewsPage().clickOnClosePopup();

        assertEquals(getNewsPage().getNewsCount(), 15);
    }

    @Test
    public void findHeadLineArticle() {
        getHomePage().clickOnNews();
        getHomePage().waitVisibilityOfPopup(30, getNewsPage().getPopup());
        getNewsPage().clickOnClosePopup();

    }

    @Test
    public void checkFirstArticleName() {
        getHomePage().clickOnNews();
        getHomePage().waitVisibilityOfPopup(30, getNewsPage().getPopup());
        getNewsPage().clickOnClosePopup();

        }
    }

