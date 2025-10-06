package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wishlist_Page {

    private WebDriver driver;
    private final Register register ;
    public Wishlist_Page(WebDriver driver) {
        this.driver = driver;
        register = new Register(driver);
    }

    //locators
    By product=By.cssSelector("div.header-menu ul.top-menu.notmobile li > a[href='/books']");
    By productID=By.cssSelector("div.product-item[data-productid='39'] button.add-to-wishlist-button");
    By wishlistCloseBar=By.cssSelector("span.close");
    By wishlistbtn=By.cssSelector("span.wishlist-label");
    By addtoCartCheckbox=By.xpath("//input[@name='addtocart']");
    By addtoCartbtn=By.cssSelector("button.button-2.wishlist-add-to-cart-button");
    By acceptTerms=By.cssSelector("input#termsofservice");
    By checkoutbtn=By.cssSelector("button[name^='check']");

    By dropdownSelect=By.cssSelector("select[data-trigger='state-select']");
    By City =By.xpath("//input[@id='BillingNewAddress_City']");
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


    //loacators
    By accountbtn= By.cssSelector("a.ico-account");
    By emailField=  By.id("Email");
    By savebtn= By.cssSelector("button#save-info-button");


    public void loginn() {
        register.register_data();
    }

    public  void addProductToWishlist(){
        driver.findElement(product).click();
        driver.findElement(productID).click();
    }

    public void addProducttoCart(){
       driver.findElement(wishlistCloseBar).click();
       driver.findElement(wishlistbtn).click();
       driver.findElement(addtoCartCheckbox).click();
       driver.findElement(addtoCartbtn).click();
    }

    public void checkout() throws InterruptedException {
        driver.findElement(acceptTerms).click();
        driver.findElement(checkoutbtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Select select= new Select(driver.findElement(dropdownSelect));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownSelect));
        select.selectByValue("1714");
        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(City));
        cityField.sendKeys("cairo");
        driver.findElement(Address1).sendKeys("cairo");
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button-1.order-completed-continue-button"))).click();
    }


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
