package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestDataReader;

import java.time.Duration;

public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
//    String currenttime = String.valueOf(System.currentTimeMillis());
//    String mail = TestDataReader.get("emailPrefix") + currenttime + TestDataReader.get("emailDomain");
    //loacators

    By accountbtn= By.cssSelector("a.ico-account");
    By emailField=  By.id("Email");
    By savebtn= By.cssSelector("button#save-info-button");


    public void updateEmail(String mail) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the element is visible and clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountbtn));
        wait.until(ExpectedConditions.elementToBeClickable(accountbtn));

        // Optionally, switch to iframe if the element is inside one
        // driver.switchTo().frame(1);
        driver.findElement(accountbtn).click();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(mail);
        driver.findElement(savebtn).click();
    }
}
