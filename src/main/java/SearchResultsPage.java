import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;
    @FindBy(xpath = "*//div[@data-component-type='s-search-result']")
    List<WebElement> searchResultsList;
    WebElement firstItem;


    SearchResultsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void initFirstItem() {
        firstItem = searchResultsList.get(1);
    }

    void clickOnFirstItem() {
        firstItem.click();
    }


}
