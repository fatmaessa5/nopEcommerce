package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By dropdownSelect=By.cssSelector("select#BillingNewAddress_StateProvinceId");
    By City =By.cssSelector("input#BillingNewAddress_City");
    By Address1 =By.xpath("//input[@name='BillingNewAddress.Address1']");
    By zipPostalCode=By.cssSelector("input#BillingNewAddress_ZipPostalCode");
    By pohneNumber=By.cssSelector("input#BillingNewAddress_PhoneNumber");
    By continuebtn=By.cssSelector(" button[name^='save']");
    By continueShippingMethode=By.cssSelector("button.button-1.shipping-method-next-step-button");
    By paymentMethode=By.cssSelector("input#paymentmethod_1");
    By continuePaymentMethode=By.cssSelector("button.button-1.payment-method-next-step-button");
    By Cardholder_name=By.cssSelector("input#CardholderName");
    By Cardholder_number=By.cssSelector("input#CardNumber");
    By CardCode=By.cssSelector("input#CardCode");
    By expirationDate=By.cssSelector("select#ExpireMonth");
    By continueInfo=By.cssSelector("button.button-1.payment-info-next-step-button");
    By confimbtn=By.cssSelector("button.button-1.confirm-order-next-step-button");


    public void checkOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Select select= new Select(driver.findElement(dropdownSelect));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownSelect));
        select.selectByValue("1714");
        driver.findElement(City).sendKeys("cairo");
        driver.findElement(Address1).sendKeys("cairo-cairo");
        driver.findElement(zipPostalCode).sendKeys("12345");
        driver.findElement(pohneNumber).sendKeys("0101065326");
        driver.findElement(continuebtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMethode)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethode)).click();
        // driver.findElement(paymentMethode).click();
        //wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMethode)).click();
        driver.findElement(continuePaymentMethode).click();
        Thread.sleep(1000);
        driver.findElement(Cardholder_name).sendKeys("CARDDDD");
        Thread.sleep(1000);
        driver.findElement(Cardholder_number).sendKeys("4111111111111111");
        Select select1= new Select(driver.findElement(expirationDate));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDate));
        select1.selectByValue("12");
        Thread.sleep(1000);
        driver.findElement(CardCode).sendKeys("123");
        wait.until(ExpectedConditions.elementToBeClickable(continueInfo)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confimbtn)).click();
//        By orderDetails=By.xpath("//a[contains(@href,'/orderdetails/')]");
//        wait.until(ExpectedConditions.elementToBeClickable(orderDetails)).click();

    }
    public void accountPage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        By orderDetails=By.xpath("//a[contains(@href,'/orderdetails/')]");
        wait.until(ExpectedConditions.elementToBeClickable(orderDetails)).click();
        By gotoAccount=By.cssSelector("a.ico-account");
        wait.until(ExpectedConditions.elementToBeClickable(gotoAccount)).click();

        By goto_orders=By.xpath("//div[contains(@class,'block-account-navigation')]//a[contains(@href,'/order/history')]");
        driver.findElement(goto_orders).click();
    }
}
