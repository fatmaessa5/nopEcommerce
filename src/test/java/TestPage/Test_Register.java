package TestPage;


import SetUp.BasicSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Pages.Register;

import java.time.Duration;

public class Test_Register extends BasicSetUp {
    private Register register;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void initOnce() {
        register = new Register(driver);
    }

    @Test
    public void testRegisterPage() {
        register.register_data();
        //validation of registration
        WebElement registermsg = driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']"));
        softAssert.assertEquals(registermsg.getText(), "Your registration completed");
        softAssert.assertAll();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
        register.logout();
    }

}