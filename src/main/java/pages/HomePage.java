package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class HomePage extends BasePage {

    @FindBy(css = "#signin2")
    private WebElement signUpButton;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    private WebElement monitorsButton;

    @FindBy(xpath = "//b[contains(text(),'About Us')]")
    private WebElement aboutUsText;
    @FindBy(css = "#cartur")
    private WebElement cartButton;
     @FindBy(css = "#nameofuser")
     private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignUpButton() {
        clickElement(this.signUpButton);
    }

    public boolean isAboutUsDisplayed() {
        return aboutUsText.isDisplayed();
    }

    public void scrollToAboutUs() {
        Utils.scrollToElement(aboutUsText, driver);
    }

    public void clickLoginButton() {
        clickElement(this.loginButton);
    }

    public void clickMonitorButton() {
        clickElement(this.monitorsButton);
    }
    public void clickCartButton() {
        clickElement(cartButton);
    }

    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }

}
