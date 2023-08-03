package demoblazeTests;

import constants.Constants;
import constants.ErrorMessages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.Utils;

public class LoginTest extends BaseTest {
    private LogInPage logInPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        this.logInPage = new LogInPage(this.driver);
    }

    @Test
    public void loginTest() {
        this.homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        this.logInPage.inputUsername();
        this.logInPage.inputPassword();
        this.logInPage.clickLogInButton();
        Utils.waitInSeconds(2);
        String actualMessage = this.homePage.getWelcomeMessageText();
        Assert.assertTrue(actualMessage.contains(Constants.WELCOME_MESSAGE));
    }

    @Test
    public void noUsernameAndPasswordEnteredTest() {
        this.homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        this.logInPage.clickLogInButton();
        Utils.waitInSeconds(2);
        String expectedMessage = Constants.LOGIN_OR_SIGNUP_ERROR_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(expectedMessage, actualMessage);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
        Utils.waitInSeconds(2);
    }

    @Test
    public void noUsernameOnlyPasswordInsertedTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        logInPage.inputPassword();
        logInPage.clickLogInButton();
        Utils.waitInSeconds(2);
        String expectedMessage = Constants.LOGIN_OR_SIGNUP_ERROR_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_LOGIN_FIELDS_ARE_EMPTY);
        Utils.acceptAlert(this.driver);
        Utils.waitInSeconds(2);
    }

    @Test
    public void onlyUsernameInsertedNoPasswordTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        logInPage.inputUsername();
        logInPage.clickLogInButton();
        Utils.waitInSeconds(2);
        String expectedMessage = Constants.LOGIN_OR_SIGNUP_ERROR_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_LOGIN_FIELDS_ARE_EMPTY);
        Utils.acceptAlert(this.driver);
        Utils.waitInSeconds(2);
    }

    @Test
    public void wrongUsernameTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        logInPage.inputGeneratedUsername();
        logInPage.inputPassword();
        logInPage.clickLogInButton();
        Utils.waitInSeconds(2);
        String expectedMessage = Constants.LOGIN_WRONG_USERNAME;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.USER_NOT_EXIST);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void wrongPasswordTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        logInPage.inputUsername();
        logInPage.inputGeneratedPassword();
        logInPage.clickLogInButton();
        Utils.waitInSeconds(2);
        String actualMessage = Utils.getAlertText(this.driver);
        String expectedMessage = Constants.LOGIN_WRONG_PASSWORD;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.INCORRECT_PASSWORD);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void logInTitleExistsTest() {
        this.homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        Assert.assertTrue(this.logInPage.logInTitleIsDisplayed(), ErrorMessages.MISSING_TITLE);
        Utils.waitInSeconds(1);
        String actualText = this.logInPage.getLogInTitle();
        String expectedText = Constants.LOGIN_TITLE;
        Assert.assertEquals(actualText, expectedText, ErrorMessages.TITLE_TEXT_INCORRECT);
        }

        @Test
        public void logInButtonExistsTest() {
        this.homePage.clickLoginButton();
        Utils.waitInSeconds(2);
        Assert.assertTrue(this.logInPage.logInButtonExists(), ErrorMessages.LOGIN_BUTTON_IS_MISSING);
        Utils.waitInSeconds(1);
        }









}
