package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='loginusername']")
    protected WebElement usernameField;
    @FindBy(xpath = "//input[@id='loginpassword']")
    protected WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    protected WebElement logInButton;
    @FindBy(xpath = "//h5[@id='logInModalLabel']")
    protected WebElement logInTitle;

    public void inputUsername() {
        this.usernameField.sendKeys(Constants.USERNAME);
    }

    public void inputPassword() {
        this.passwordField.sendKeys(Constants.PASSWORD);
    }

    public void clickLogInButton() {
        this.logInButton.click();
    }

    public void inputGeneratedUsername() {
        this.usernameField.sendKeys(Constants.generateUsername());
    }

    public void inputGeneratedPassword() {
        this.passwordField.sendKeys(Constants.generatePassword());
    }

    public boolean logInTitleIsDisplayed() {
        return this.logInTitle.isDisplayed();
    }

    public String getLogInTitle() {
        return this.logInTitle.getText();
    }

    public boolean logInButtonExists() {
        return this.logInButton.isDisplayed();
    }

    public void fullLogIn() {
        inputUsername();
        inputPassword();
        clickLogInButton();
    }
}
