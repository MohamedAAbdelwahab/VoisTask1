import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(css = "input[id='twotabsearchtextbox']")
    WebElement searchBar;
    @FindBy(css = "input[data-action-type='DISMISS']")
    WebElement dismissBTN;
    @FindBy(css = "a[href='/gp/goldbox?ref_=nav_cs_gb']")
    WebElement todaysDeals;
    HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void openAmazon() {
        driver.get("https://www.amazon.com/");

    }

    void enterKeyword(String keyword) {
        searchBar.sendKeys(keyword);

    }


    void clickOnEnter() {
        searchBar.sendKeys(Keys.ENTER);
    }

    void clickOnDismiss() {
        dismissBTN.click();
    }

    void clickOnTodaysDeals()
    {
        todaysDeals.click();
    }
}
