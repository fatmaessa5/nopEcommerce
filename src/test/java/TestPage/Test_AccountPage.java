package TestPage;

import Pages.AccountPage;
import SetUp.BasicSetUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_AccountPage extends BasicSetUp {
      private AccountPage accountPage;
      @BeforeMethod
        public void initOnce() {
            accountPage = new AccountPage(driver);// Pass driver to AccountPage
        }
        @Test
        public void testAccountPage() {
            String currenttime = String.valueOf(System.currentTimeMillis());
            String mail = "user" + currenttime + "@example.com";
            accountPage.updateEmail(mail);
        }
}
