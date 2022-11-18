import com.relevantcodes.extentreports.LogStatus;
import groovy.util.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Level;

public class SecondTest extends BaseTest {
    HomePage homePage;
    TodaysDealsPage todaysDealsPage;
    SoftAssert softAssert=new SoftAssert();
    @Test(priority = 1)
    void openAmazon() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openAmazon();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/");
        softAssert.assertAll();
        test.log(LogStatus.PASS, "opened amazon ");

    }

    @Test(priority = 2)
    void DismissMessage() throws InterruptedException {

        try {
            util.waitUntil(driver, By.cssSelector("input[data-action-type='DISMISS']"));
            homePage.clickOnDismiss();
        } catch (Exception e) {
            logger.log(Level.FINE, "*We're showing you items that ship to EG. To see items that ship to a different country, change your delivery address.\n* message didn't appear ");
        }
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    void navigateToTodaysDealsPage() throws InterruptedException {

        homePage.clickOnTodaysDeals();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
        softAssert.assertAll();

    }

    @Test(priority = 4)
    void selectGroceryAndHeadphones() throws InterruptedException {
        todaysDealsPage = new TodaysDealsPage(driver);
        todaysDealsPage.initDepartmentsListItems();
        todaysDealsPage.selectGroceryAndHeadphones();
    }

    @Test(priority = 5)
    void select10OffOrMore() throws InterruptedException {
        todaysDealsPage.initDiscountFilterListItems();
        todaysDealsPage.select10OffOrMore();

    }

    @Test(priority = 6)
    void scrollAndClickOnPage3and4() throws InterruptedException {
        todaysDealsPage.initListOfPages();
        todaysDealsPage.scrollAndClickOnPage3();
        Thread.sleep(1000);
        todaysDealsPage.initListOfPages();
        todaysDealsPage.scrollAndClickOnPage4();
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    void scrollAndClickOnProduct() throws InterruptedException {
        todaysDealsPage.initListOfResults();
        todaysDealsPage.scrollAndClickOnProduct();
    }

}
