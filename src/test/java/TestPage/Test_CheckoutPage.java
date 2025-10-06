package TestPage;

import Pages.AddToCartPage;
import Pages.CheckoutPage;
import SetUp.BasicSetUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_CheckoutPage extends BasicSetUp {
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void initOnce() {
        checkoutPage = new CheckoutPage(driver);
    }
    @Test
    public void testcheckout() throws InterruptedException {
        checkoutPage.accountPage();
    }
}
