package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestDataReader;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    public Login(WebDriver driver) {this.driver = driver;}

    String currenttime = String.valueOf(System.currentTimeMillis());
    String mail = TestDataReader.get("emailPrefix") + currenttime + TestDataReader.get("emailDomain");
    String password = TestDataReader.get("password");

    //locators

    By loginButtonLocator = By.xpath("//a[@class='ico-login']");
    //WebElement loginbtn = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
    By EmailField=By.id("Email");
    By password_field=By.cssSelector("input[class='password']");

    public void enterLoginPage(){
        driver.findElement(loginButtonLocator).click();
    }
    public void enteremail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }
    public void enterpassword(String password){
        driver.findElement(password_field).sendKeys(password);
    }
    public void login(){
        enterLoginPage();
        enteremail(mail);
        enterpassword(password);
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
    }

}
