package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='register()']")
    protected WebElement signUpButton;

    @FindBy(xpath = "//button[@onclick='register()']")
    protected WebElement registerButton;

    @FindBy(xpath = "//h5[@id='signInModalLabel']")
    protected WebElement signUpTitle;

    @FindBy(xpath = "(//button[contains(text(),'Close')])[2]")
    protected WebElement closeButton;

    public void inputValidCredentials() {
        this.usernameField.sendKeys(Constants.generateUsername());
        this.passwordField.sendKeys(Constants.PASSWORD);
        this.signUpButton.click();

    }

    public boolean isSignUpButtonDisplayed() {
        return this.registerButton.isDisplayed();
    }

    public String getSignUpTitle() {
        return this.signUpTitle.getText();
    }

    public boolean signUpTitleExists() {
        return this.signUpTitle.isDisplayed();
    }

    public void clickSignUpButton() {
        this.registerButton.click();
    }

    public void inputGeneratedUsername() {
        this.usernameField.sendKeys(Constants.generateUsername());
    }

    public void inputPassword() {
        this.passwordField.sendKeys(Constants.PASSWORD);
    }

    public void inputUsername() {
        this.usernameField.sendKeys(Constants.USERNAME);
    }

    public void inputGeneratedPassword() {
        this.passwordField.sendKeys(Constants.generatePassword());
    }

    public String getSignUpButtonColor() {
        return this.registerButton.getCssValue(Constants.BACKGROUND_COLOR);
    }
    public boolean isCloseButtonDisplayed() {
        return this.closeButton.isDisplayed();
    }
}
