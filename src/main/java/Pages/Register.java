package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.TestDataReader;

public class Register {

    private WebDriver driver;
    public Register(WebDriver driver) {
        this.driver = driver;
    }

    String currenttime = String.valueOf(System.currentTimeMillis());
    String mail = TestDataReader.get("emailPrefix") + currenttime + TestDataReader.get("emailDomain");
    String password = TestDataReader.get("password");

    //locators

    By registerbtn=By.cssSelector("a[class='ico-register']");
    By Gender   =By.xpath("//label[text()='Female']");
    By FirstName=By.id("FirstName");
    By LastName =By.id("LastName");
    By Email    =By.name("Email");
    By Password =By.name("Password");
    By Confirm_password =By.name("ConfirmPassword");
    By submitbtn=By.cssSelector("button[name='register-button']");
    By logout_button=By.linkText("Log out");

    public void register_data(){
        driver.findElement(registerbtn).click();
        driver.findElement(Gender).click();
        driver.findElement(FirstName).sendKeys("fatma");
        driver.findElement(LastName).sendKeys("essa");
        driver.findElement(Email).sendKeys(mail);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(Confirm_password).sendKeys("123456789");
        driver.findElement(submitbtn).click();
    }

    public void logout(){

        driver.findElement(logout_button).click();
    }

}
