package demoblazeTests;
import constants.Constants;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        this.driver = new ChromeDriver();
        this.driver.get(Constants.URL);
        this.driver.manage().window().maximize();
        this.homePage = new HomePage(this.driver);
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
    }

}
