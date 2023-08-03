package demoblazeTests;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void verifyAboutUsIsDisplayedTest() {
        this.homePage.scrollToAboutUs();
        Assert.assertTrue(this.homePage.isAboutUsDisplayed(),
                ErrorMessages.ABOUT_US_TEXT_IS_MISSING);
    }
}
