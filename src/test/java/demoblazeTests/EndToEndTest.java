package demoblazeTests;
import constants.Constants;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LogInPage;
import pages.MonitorsPage;
import pages.ProductPage;
import utils.Utils;

public class EndToEndTest extends BaseTest {
    private MonitorsPage monitorsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private LogInPage logInPage;

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        monitorsPage = new MonitorsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        logInPage = new LogInPage(driver);
    }

    @Test
    public void endToEndFlowTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        this.logInPage.fullLogIn();
        Utils.waitInSeconds(2);
        String actualMessage = homePage.getWelcomeMessageText();
        Assert.assertTrue(actualMessage.contains(Constants.WELCOME_MESSAGE));
        homePage.clickMonitorButton();
        Utils.waitInSeconds(1);
        monitorsPage.clickAsusMonitorLink();
        Utils.waitInSeconds(1);
        productPage.clickAddToCartButton();
        Utils.waitInSeconds(1);
        Assert.assertEquals(Utils.getAlertText(driver), Constants.PRODUCT_ADDED_TEXT,
                ErrorMessages.INCORRECT_ALERT_BOX_TEXT);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(driver);
        Utils.waitInSeconds(1);
        homePage.clickCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickPlaceOrderButton();
        Utils.waitInSeconds(1);
    }
}
