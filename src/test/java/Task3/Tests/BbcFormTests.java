package Task3.Tests;

import Task3.Pages.FormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BbcFormTests extends BaseTest{

    private final String INPUT_NAME = "Anastasiia";
    private final String INPUT_CONTACT = "1432";
    private final String INPUT_LOCATION = "Ukraine";
    private final String EXPECTED_URL = "news";
    private final String INPUT_EMAIL = "345@gmail.com";
    private final String TEXT = "hello coronavirus";

    @Test
    public void submitNewsWithOutRequiredCheckBoxClick() {
        getHomePage()
            .clickOnNews();
            .waitVisibilityOfPopup(30, getNewsPage().getPopup());
        getNewsPage()
            .clickOnClosePopup();
            .clickOnCoronavirusTab();
            .clickYourStory();
            .clickOnShare();
        getFormPage().nameInput(INPUT_NAME);
        getFormPage().contactInput(INPUT_CONTACT);
        getFormPage().location(INPUT_LOCATION);
        getFormPage().clickOnAcceptions();
        getFormPage().clickOnSendButton();

        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_URL));
    }

    @Test
    public void submitNewsWithInvalidEmail() {
        getHomePage()
            .clickOnNews();
            .waitVisibilityOfPopup(30, getNewsPage().getPopup());
        getNewsPage()
            .clickOnClosePopup();
            .clickOnCoronavirusTab();
            .clickYourStory();
            .clickOnShare();
        getFormPage().nameInput(INPUT_NAME);
        getFormPage().contactInput(INPUT_CONTACT);
        getFormPage().location(INPUT_LOCATION);
        getFormPage().email(INPUT_EMAIL);
        getFormPage().clickOnAcceptions();
        getFormPage().clickOnYear();
        getFormPage().clickOnSendButton();

        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_URL));
    }

    @Test
    public void submitNewsWithEmptyTextBox() {
        getHomePage()
            .clickOnNews();
            .waitVisibilityOfPopup(30, getNewsPage().getPopup());
        getNewsPage()
            .clickOnClosePopup();
            .clickOnCoronavirusTab();
            .clickYourStory();
            .clickOnShare();
        getFormPage().textarea(TEXT);
        getFormPage().nameInput(INPUT_NAME);
        getFormPage().contactInput(INPUT_CONTACT);
        getFormPage().location(INPUT_LOCATION);
        getFormPage().email(INPUT_EMAIL);
        getFormPage().clickOnAcceptions();
        getFormPage().clickOnYear();
        getFormPage().clickOnSendButton();

        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_URL));
    }
}
