package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.linkText("Electronics"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndNavigateToSubMenu(By.linkText("Electronics"), By.linkText("Cell phones"));
        //1.3 Verify the text “Cell phones”
        verifyTextMessage("not navigated to Cell phones page", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.linkText("Electronics"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndNavigateToSubMenu(By.linkText("Electronics"), By.linkText("Cell phones"));
        //2.3 Verify the text “Cell phones”
        verifyTextMessage("not navigated to Cell phones page", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(5000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyTextMessage("Unable to navigate to the product page-Nokia Lumia", "Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        //2.7 Verify the price “$349.00”
        verifyTextMessage("Unable to confirm price of the product","$349.00", By.cssSelector("#price-value-20"));
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/input[1]"),"2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.cssSelector("#add-to-cart-button-20"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar by clicking on the cross button.
        verifyTextMessage("Unable to verify that product has  been added to shopping cart", "The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        clickOnElement(By.xpath("//span[@title = 'Close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        mouseHoverAndNavigateToSubMenu(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12 Verify the message "Shopping cart"
        verifyTextMessage("Not navigated to the Shopping cart","Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.13 Verify the quantity is 2
        Thread.sleep(2000);
        String expectedQuantity = "2";
        WebElement wb = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        String actualQuantity = wb.getAttribute("value");
        //System.out.println(quantity);
        Assert.assertEquals(expectedQuantity, actualQuantity);
        //2.14 Verify the Total $698.00
        verifyTextMessage("Unable to confirm the total amount in the cart","$698.00", By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.cssSelector("#checkout"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTextMessage("User not taken to Sign in page", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        verifyTextMessage("user not taken to the Register page","Register", By.xpath("//h1[contains(text(),'Register')]"));
        //2.20 Fill the mandatory fields
        //firstname
        sendTextToElement(By.cssSelector("#FirstName"), "Testerhv0");
        //lastname
        sendTextToElement(By.cssSelector("#LastName"), "Automations0");
        //email
        sendTextToElement(By.cssSelector("#Email"), "testerhv0@gmail.com");
        //password
        sendTextToElement(By.cssSelector("#Password"), "123456789");
        //confirm password
        sendTextToElement(By.cssSelector("#ConfirmPassword"), "123456789");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.cssSelector("#register-button"));
        //2.22 Verify the message “Your registration completed”
        verifyTextMessage("Registration not complete", "Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping cart”
        verifyTextMessage("User not navigated to Shopping cart","Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.cssSelector("#termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.cssSelector("#checkout"));
        //2.27 Fill the Mandatory fields
        //select country
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        //city
        sendTextToElement(By.cssSelector("#BillingNewAddress_City"), "Oldham");
        //Address line 1
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "House 101");
        //post code
        sendTextToElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"), "M12 6AW");
        //phone no
        sendTextToElement(By.cssSelector("#BillingNewAddress_PhoneNumber"), "07897845654");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.cssSelector("#shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        //select credit card
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        //click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //Visa credit card is default selected - filling out the card details
        sendTextToElement(By.cssSelector("#CardholderName"), "Testerhv");
        sendTextToElement(By.cssSelector("#CardNumber"), "4012888888881881");
        sendTextToElement(By.cssSelector("#ExpireMonth"), "02");
        sendTextToElement(By.cssSelector("#ExpireYear"), "2025");
        sendTextToElement(By.cssSelector("#CardCode"), "0821");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyTextMessage("Unable to confirm payment method", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyTextMessage("Unable to confirm shipping method", "2nd Day Air", By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        //2.37 Verify Total is “$698.00”
        verifyTextMessage("Cart total is not $698.00", "$698.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank you”
        verifyTextMessage("unable to confirm the Thank you message", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyTextMessage("Unable to confirm that order has been processed","Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        verifyTextMessage("not navigated to the store welcome page","Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();
        Assert.assertEquals("url is not https://demo.nopcommerce.com/ ","https://demo.nopcommerce.com/", url);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
