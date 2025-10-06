package TestPage;

import Pages.Login;
import SetUp.BasicSetUp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Login extends BasicSetUp {
    private Login login;
    @BeforeMethod
    public void initOnce() {
        login = new Login(driver);// Pass driver to Login
    }
    @Test
    public void testLoginPage() {
        login.login();
    }
}
