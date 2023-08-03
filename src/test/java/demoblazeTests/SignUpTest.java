package demoblazeTests;

import constants.Constants;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utils.Utils;

public class SignUpTest extends BaseTest {
    private SignUpPage signUpPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        this.signUpPage = new SignUpPage(this.driver);
    }

    @Test(priority = 1)
    public void signInTest() {

        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        this.signUpPage.inputValidCredentials();
        Utils.waitInSeconds(2);

        String expectedMessage = Constants.SIGNUP_SUCCESSFUL_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(expectedMessage, actualMessage);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
        Utils.waitInSeconds(2);
    }

    @Test(priority = 2)
    public void signUpWithNoPasswordTest() {
        this.homePage.clickSignUpButton();
        this.signUpPage.inputGeneratedUsername();
        Utils.waitInSeconds(1);
        this.signUpPage.clickSignUpButton();
        Utils.waitInSeconds(2);
        String expectedMessage = Constants.LOGIN_OR_SIGNUP_ERROR_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_LOGIN_FIELDS_ARE_EMPTY);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(this.driver);
    }

    @Test(priority = 4)
    public void signUpWithNoUsernameTest() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        this.signUpPage.inputPassword();
        Utils.waitInSeconds(2);
        this.signUpPage.clickSignUpButton();
        Utils.waitInSeconds(2);
        String actualMessage = Utils.getAlertText(this.driver);
        String expectedMessage = Constants.LOGIN_OR_SIGNUP_ERROR_MESSAGE;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_LOGIN_FIELDS_ARE_EMPTY);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
    }

    @Test(priority = 6)
    public void signUpWithNoUsernameOrPasswordTest() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(2);
        this.signUpPage.clickSignUpButton();
        Utils.waitInSeconds(2);
        String actualMessage = Utils.getAlertText(this.driver);
        String expectedMessage = Constants.LOGIN_OR_SIGNUP_ERROR_MESSAGE;
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_LOGIN_FIELDS_ARE_EMPTY);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);
    }

    @Test(priority = 5)
    public void signUpWithAnUserThatAlreadyExistsTest() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        this.signUpPage.inputUsername();
        Utils.waitInSeconds(2);
        this.signUpPage.inputGeneratedPassword();
        Utils.waitInSeconds(2);
        this.signUpPage.clickSignUpButton();
        Utils.waitInSeconds(2);
        String expectedMessage = Constants.SIGNUP_USER_ALREADY_EXISTS_MESSAGE;
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGNUP_WITH_AN_EXISTING_USER);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(this.driver);

    }

    @Test(priority = 3)
    public void buttonForSignUpExistsTest() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(this.signUpPage.isSignUpButtonDisplayed(), ErrorMessages.SIGNUP_BUTTON_NOT_DISPLAYED);
        Utils.waitInSeconds(2);
    }

    @Test(priority = 8)
    public void buttonForCloseWhenYouSignUpExists() {
        this.homePage.clickSignUpButton();
        utils.Utils.waitInSeconds(2);
        Assert.assertTrue(this.signUpPage.isCloseButtonDisplayed(), ErrorMessages.CLOSE_BUTTON_IS_MISSING);
    }

    @Test(priority = 9)
    public void signInTitleExistsTest() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(this.signUpPage.signUpTitleExists(), ErrorMessages.MISSING_TITLE);
        Utils.waitInSeconds(2);
        String expectedText = Constants.SIGNUP_TITLE;
        String actualText = this.signUpPage.getSignUpTitle();
        System.out.println(actualText);
        Utils.waitInSeconds(2);
        Assert.assertEquals(actualText, expectedText, ErrorMessages.TITLE_TEXT_INCORRECT);
        Utils.waitInSeconds(2);
    }

    @Test(priority = 7)
    public void signUpButtonColorTest() {
        this.homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        String expectedColor = Constants.blueColor;
        String actualColor = signUpPage.getSignUpButtonColor();
        Assert.assertEquals(actualColor, expectedColor, ErrorMessages.SIGNUP_BUTTON_COLOR_INCORRECT);
        Utils.waitInSeconds(1);
    }
}
