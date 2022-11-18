import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TodaysDealsPage {
    WebDriver driver;
    @FindBy(css = "span[aria-label='Departments filter'] ul")
    WebElement departmentsListElement;
    List<WebElement> departmentsListItems;
    @FindBy(css = "span[aria-label='Discount filter'] ul")
    WebElement discountFilterElement;
    List<WebElement> discountFilterListItems;
    WebElement firstItem;
    @FindBy(className = "a-pagination")
    WebElement pagination;
    List<WebElement> listOfPages;
    @FindBy(css = "div[data-testid='grid-deals-container']")
    WebElement resultsElement;
    List<WebElement> listOfResults;

    TodaysDealsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void initDepartmentsListItems() {
        departmentsListItems = departmentsListElement.findElements(By.xpath("./child::*"));
    }

    void initDiscountFilterListItems() {
        discountFilterListItems = discountFilterElement.findElements(By.xpath("./child::*"));
    }

    void initListOfPages() {
        listOfPages = pagination.findElements(By.xpath("./child::*"));
    }

    void selectGroceryAndHeadphones() throws InterruptedException {
        for (WebElement element : departmentsListItems) {
            if (element.getText().equals("Grocery")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                Thread.sleep(1000);

            }
            if (element.getText().equals("Headphones")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                Thread.sleep(1000);

            }
        }
    }

    void select10OffOrMore() throws InterruptedException {
        for (WebElement element : discountFilterListItems) {
            if (element.getText().equals("10% off or more")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                element.click();
                Thread.sleep(1000);

            }

        }
    }

    void scrollAndClickOnPage3() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listOfPages.get(3));
        listOfPages.get(3).findElement(By.cssSelector("a[href='#']")).click();

    }

    void scrollAndClickOnPage4() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listOfPages.get(4));
        listOfPages.get(4).findElement(By.cssSelector("a[href='#']")).click();

    }

    void initListOfResults() {
        listOfResults = resultsElement.findElements(By.xpath("./child::*"));
    }

    void scrollAndClickOnProduct() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listOfResults.get(0));
        for(WebElement element:listOfResults)
        {
            element.click();
            Thread.sleep(1000);

            try
            {
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.findElement(By.cssSelector("a[href='/gp/cart/view.html?ref_=sw_gtc']")).click();
                break;
            }
            catch (Exception e)
            {
                System.out.println("Item is either out of stock or amazon just detected that i am an automation and gave me a deal instead of a product");
            }
        }

    }
    void clickOnFirstItem() {
        firstItem.click();
    }


}
