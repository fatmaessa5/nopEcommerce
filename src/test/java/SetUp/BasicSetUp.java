package SetUp;

import ReportManager.ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicSetUp {
    protected WebDriver driver;
    ExtentReports  extentReports ;
    ExtentTest test;

    @BeforeClass
    public void navigateToHomePage() {
        extentReports= ReportManager.getInstance();
        test=extentReports.createTest("testEcommerce");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void tearDown() {
        // If driver is initialized, quit it after test execution
        if (driver != null) {
            driver.quit();
        }
        extentReports.flush();
    }


}
