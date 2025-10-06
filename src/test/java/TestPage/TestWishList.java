package TestPage;
import Pages.AccountPage;
import Pages.Login;
import Pages.Wishlist_Page;
import SetUp.BasicSetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestWishList extends BasicSetUp {

    private Wishlist_Page wishlist;
    private Login login;
    private AccountPage accountPage ;
    SoftAssert softAssert=new SoftAssert();


    @BeforeMethod
    public void initOnce() {

        wishlist = new Wishlist_Page(driver);
        login = new Login(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void Awishlist() throws InterruptedException {

        wishlist.loginn();
        wishlist.addProductToWishlist();
        By orderAdded_msg = By.xpath("//p[@class='content']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderAdded_msgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(orderAdded_msg));
        String actualMessage = orderAdded_msgElement.getText();
        softAssert.assertEquals(actualMessage, "The product has been added to your wishlist");
        softAssert.assertAll();
        wishlist.addProducttoCart();
        wishlist.checkout();
        String currenttime = String.valueOf(System.currentTimeMillis());
        String mail = "user" + currenttime + "@example.com";
        accountPage.updateEmail(mail);

        By coustomerInfo_msg= By.xpath("//p[@class='content']");
        WebElement coustomerInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(coustomerInfo_msg));
        String actualMessage2 = coustomerInfo.getText();
        softAssert.assertEquals(actualMessage2, "The customer info has been updated successfully.");
        softAssert.assertAll();

    }
//    @Test
//    public void BtestAccountPage() {
//        String currenttime = String.valueOf(System.currentTimeMillis());
//        String mail = "user" + currenttime + "@example.com";
//        accountPage.updateEmail(mail);
//    }
}
