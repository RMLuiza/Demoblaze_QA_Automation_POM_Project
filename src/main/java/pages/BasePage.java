package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // pentru a putea folosi variabilele de tip WebElement trebuie sa aplicam Page Factory in
    // constructorul fiecarei clase care declara WebElement

    // Conversie id si class catre css
    // Ex: id='login2'  -->> #login2
    // Ex2: id='btn btn-primary'  -->> #ctn.btn-primary
    // Ex clase: class='signup2'  -->> .signup2
    // Ex2 clase: class=b'btn btn-primary'  -->> .btn.btn-primary

    // xpath -> css
    // //button[@type='login'] -> button[type='login']
}
