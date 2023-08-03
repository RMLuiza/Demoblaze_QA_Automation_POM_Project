package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "button[data-target='#orderModal']")
    private WebElement placeOrderButton;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrderButton() {
        clickElement(placeOrderButton);
    }
}
