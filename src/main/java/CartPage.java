import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;
    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=sw_gtc']")
    WebElement cartBTN;
    @FindBy(xpath = "*//div[@class='sc-list-item-content']")
    WebElement cartItems;
    @FindBy(xpath = "(//span[@aria-hidden='true'])[9]")
    WebElement productInCart;

    CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToCart() throws InterruptedException {
        Thread.sleep(1200);
        cartBTN.click();
    }

    public int getCartItemsCount() {
        return cartItems.findElements(By.xpath("./child::*")).size();
    }

    public String getProductName() {
        return productInCart.getText();
    }
}
