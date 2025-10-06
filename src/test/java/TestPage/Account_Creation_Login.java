//package TestPage;
//
//import Pages.PurchaseFlow;
//import Pages.Wishlist_Profile_Management;
//import SetUp.BasicSetUp;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//import Pages.Register;
//
//import java.time.Duration;
//
//public class Account_Creation_Login extends BasicSetUp {
//    private Register register;
//    private PurchaseFlow purchaseFlow;
//    private Wishlist_Profile_Management wishlist;
//    SoftAssert softAssert=new SoftAssert();
//    @BeforeClass
//    public void initOnce() {
//      //  register = new Register(driver);
//       // purchaseFlow = new PurchaseFlow(driver);
//       // wishlist =new Wishlist_Profile_Management(driver);
//    }
//
//    @Test
//    public void testRegisterPage() {
//        register.Fill_data();
//        WebElement registermsg=driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']"));
//        softAssert.assertEquals(registermsg.getText(),"Your registration completed");
//        softAssert.assertAll();
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
//        register.logout();
//    }
//    @Test
//    public void testlogin(){
//        register.login();
//    }

//    @Test
//    public void testpurchase() throws InterruptedException {
//        purchaseFlow.purchase();
//        purchaseFlow.product();
       // purchaseFlow.checkOut();
      //  WebElement confirmmsg=driver.findElement(By.xpath("//div[contains(@class,'order-completed')]//div[contains(@class,'title')]//strong[contains(normalize-space(.),'successfully')]"));
      //  softAssert.assertEquals(confirmmsg.getText(),"Your order has been successfully processed!");
      //  softAssert.assertAll();
      //  purchaseFlow.accountPage();
      //  WebElement verifyorder=driver.findElement(By.xpath(" //*[contains(text(),'Order Number')]"));
      //  softAssert.assertEquals(verifyorder.getText(),"Order Number: 10");
      //  softAssert.assertAll();

       // purchaseFlow.accountPage();
       // WebElement verifyOrder = driver.findElement(By.xpath("//div[@class='order-list']//strong"));
//        String orderText = verifyOrder.getText();
//        softAssert.assertTrue(orderText.matches("Order Number: \\d+"),
//                "Order text does not match expected pattern. Found: " + orderText);
//        softAssert.assertAll();


//    }

//    @Test
//    public void wishlist() {
//        register.logout();
//        wishlist.loginn();
//        wishlist.addProductToWishlist();
//    }

