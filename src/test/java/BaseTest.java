import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    Logger logger=Logger.getLogger("Logger for assignment");

    WebDriver driver;
    Utils util=new Utils();
    WebDriverWait wait;
    static ExtentTest test;
    static ExtentReports report;
    @AfterClass
    public void cleanUP()
    {
        driver.close(); //Close the browser window
        report.endTest(test);
        report.flush();
    }

    @BeforeClass
    public void setup()
    {
        driver=util.setup();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.setLevel(Level.FINE);
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        report = new ExtentReports(System.getProperty("user.dir")+ File.separator+"ExtentReportResults.html");
        report.loadConfig(new File(System.getProperty("user.dir") +File.separator+ "\\extent-config.xml"));
        driver.manage().window().maximize();
        test = report.startTest("VOIS Task Automation");
        wait = new WebDriverWait(driver,30);
    }

}
