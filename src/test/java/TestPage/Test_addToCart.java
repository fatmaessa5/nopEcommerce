package TestPage;
import Pages.AddToCartPage;
import Pages.Register;
import SetUp.BasicSetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class Test_addToCart extends BasicSetUp {


    private Register register;
    private AddToCartPage addToCartPage;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setupPages() {
        addToCartPage = new AddToCartPage(driver);
        register = new Register(driver);
    }



    @Test
    public void testpurchase() throws InterruptedException {
        addToCartPage.purchase();
       By confirmmsg = By.xpath("//*[contains(@class,'title')]//strong[text()='Your order has been successfully processed!']");
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement confirmmsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmmsg));
       String actualMessage = confirmmsgElement.getText();
       softAssert.assertEquals(actualMessage, "Your order has been successfully processed!");
       softAssert.assertAll();

    }
}
