package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddToCartPage {

    private WebDriver driver;
    Register register;
    Actions action;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        register =new Register(driver);
        action= new Actions(driver);
    }
  //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By searchBar = By.cssSelector("input[name='q']");
    By searchSubmit = By.cssSelector("button[type='submit']");
    private final By handles = By.cssSelector("#price-range-slider .ui-slider-handle");
    By sortBy = By.xpath("//select[@aria-label='Select product sort order']");
    By closeBar=By.cssSelector("span[title='Close']");
    By shoppingCart=By.xpath("//span[@class='cart-label']");
    By editQty=By.xpath("//div[starts-with(@id,'quantity-up-')]");
    By acceptTerms=By.cssSelector("input#termsofservice");


//    //Locators
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


    public void enterHomePage(){
        register.register_data();
    }
    public void searchOnProduct() {
       driver.findElement(searchBar).sendKeys("laptop");
       driver.findElement(searchSubmit).click();
    }
    public void applySorting(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement handlesElement = wait.until(ExpectedConditions.presenceOfElementLocated(handles));
            action.clickAndHold(handlesElement).moveByOffset(30, 0).release().perform();
            WebElement sort = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
            new Select(sort).selectByVisibleText("Price: Low to High");

    }
    public void addProductToCart()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By addToCartLocator = By.xpath("//h2/a[text()='Lenovo Thinkpad Carbon Laptop']/parent::h2/following-sibling::div[@class='add-info']/div[@class='buttons']/button[1]");
        // Wait for the "Add to Cart" button to be clickable and fresh
        WebElement btncart = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(addToCartLocator)));
        // Scroll to the button (optional but recommended)
        js.executeScript("arguments[0].scrollIntoView(true);", btncart);
        // Click using JavaScript
        js.executeScript("arguments[0].click();", btncart);
    }
    public void completePurchase() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(closeBar).click();
        driver.findElement(shoppingCart).click();
        driver.findElement(editQty).click();
        wait.until(ExpectedConditions.elementToBeClickable(acceptTerms)).click();
        driver.findElement(By.cssSelector("button[name^='check']")).click();

    }
    public void checkOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
    public void purchase() throws InterruptedException {
        enterHomePage();
        searchOnProduct();
        applySorting();
        addProductToCart();
        completePurchase();
        checkOut();
       // accountPage();
    }

}
