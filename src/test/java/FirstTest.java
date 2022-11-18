import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest extends BaseTest {
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;
    String itemName;

    @Test(priority = 1)
    void openAmazon() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openAmazon();
        test.log(LogStatus.PASS, "Navigated to the specified URL");
    }

    @Test(priority = 2)
    void enterSearchCriteriaAndSearch() throws InterruptedException {
        homePage.enterKeyword("car accessories");
        homePage.clickOnEnter();
        if (driver.getCurrentUrl().contains("car+accessories"))
            test.log(LogStatus.PASS, "Search for car accessories");
        else
            test.log(LogStatus.FAIL, "Search for car accessories");

    }

    @Test(priority = 3)
    void clickOnFirstItem() throws InterruptedException {
        try {
            searchResultsPage = new SearchResultsPage(driver);
            searchResultsPage.initFirstItem();
            util.scrollUntil(searchResultsPage.firstItem);
            searchResultsPage.clickOnFirstItem();
            test.log(LogStatus.PASS, "clicked on first item");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "click on first iem");

        }
    }

    @Test(priority = 4)
    void clickAddToCart() throws InterruptedException {
        try {
            productPage = new ProductPage(driver);
            productPage.clickAddToCart();
            test.log(LogStatus.PASS, "clicked on add to cart");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "click on add to cart");

        }
    }

    @Test(priority = 5)
    void navigateToCartAndValidate() throws InterruptedException {
        try {
            cartPage = new CartPage(driver);
            cartPage.navigateToCart();
            Assert.assertEquals(cartPage.getCartItemsCount(), 1);
            test.log(LogStatus.PASS, "validate on item in cart");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "validate on item in cart");

        }
    }

}
