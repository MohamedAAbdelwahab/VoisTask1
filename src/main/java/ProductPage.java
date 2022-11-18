import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(id = "productTitle")
    WebElement productName;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void clickAddToCart() {
        addToCartBtn.click();
    }

    String getProductName() {
        return productName.getText();
    }

}
