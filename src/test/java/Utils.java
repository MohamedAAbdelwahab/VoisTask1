import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Random;

public class Utils {
    WebDriver driver;

    @BeforeClass
    public WebDriver setup() {
        String userDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userDir + File.separator + "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en-GB");


        return driver = new ChromeDriver(options);
    }

    public void scrollToElementUsingJs(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void waitForElementToBeVisible(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void HoverOnItemAndSelectSub(WebElement element, By by) {
        //Instantiating Actions class
        Actions actions = new Actions(driver);

        actions.moveToElement(element);

        WebElement subMenu = driver.findElement(by);

        actions.moveToElement(subMenu);

        actions.click().build().perform();
    }
}
