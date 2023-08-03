package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitorsPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'ASUS Full HD')]")
    private WebElement asusMonitorLink;

    public MonitorsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAsusMonitorLink() {
        clickElement(asusMonitorLink);
    }

}
