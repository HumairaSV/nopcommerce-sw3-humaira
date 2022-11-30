package computer;

import com.beust.ah.A;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //Verify the Product will arrange in Descending order
        verifyTextMessage("products not arranged in descending order","Name: Z to A",By.xpath("//select[@id='products-orderby']/option[@value = '6']"));

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //Click on "Add To Cart"
        Thread.sleep(6000);
        clickOnElement(By.xpath("//button[contains(@onclick, '(\"/addproducttocart/catalog/1/1/1\")')]"));
        //Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Page did not navigate to Build your own computer", expectedText, actualText);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/dl[1]/dd[3]/ul[1]/li[2]/input[1]"));
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[text() = 'Vista Premium [+$60.00]']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@name ='product_attribute_5' and @value = '12']"));
        //Verify the price is"$1,475.00"
        String expectedPrice = "$1,475.00";
        Thread.sleep(7000);
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-1' or text() = '$1,475.00']"));
        Assert.assertEquals("Price of customised computer does not match", expectedPrice, actualPrice);
        //Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[9]/div[1]/button[1]"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextMessage("Confirmation that item has been added to shopping cart not displayed", "The product has been added to your shopping cart", By.xpath("//p[text() = 'The product has been added to your ']"));
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        mouseHoverAndNavigateToSubMenu(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));
        //Verify the message "Shopping cart"
        verifyTextMessage("Not navigated to the Shopping cart", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        WebElement Quantity = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        Quantity.clear();
        Quantity.sendKeys("2");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //Verify the Total"$2,950.00"
        verifyTextMessage("items have not updated in the cart", "$2,950.00", By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        verifyTextMessage("User not taken to Sign in page", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //Fill the all mandatory field
        //Firstname
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Testinghv1");
        //Lastname
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Automations");
        //Email
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "testinghv0@gmail.com");
        //Country
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        //City
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Chadderton");
        //Address line 1
        sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/input[1]"), " Flat 901");
        //Postcode
        sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/input[1]"), "M14 6AA");
        //Phone no
        sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/input[1]"), "7878777777");
        //click on continue
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        Thread.sleep(2000);
        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@value = 'Next Day Air___Shipping.FixedByWeightByTotal']"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@value = 'Payments.Manual']"));
        clickOnElement(By.xpath("//button[@class = 'button-1 payment-method-next-step-button']"));
        //Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //Fill all the details
        //input cardholder name
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Testerhv");
        //input cardnumber
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 5555 5555 4444");
        //input expiration date
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "02");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        //input card code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "0821");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //Verify “Payment Method” is “Credit Card”
        verifyTextMessage("Unable to confirm the payment method", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        //Verify “Shipping Method” is “Next Day Air”
        verifyTextMessage("Unable to confirm Shipping Method", "Next Day Air", By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        //Verify Total is “$2,950.00”
        verifyTextMessage("Total is not $2950.00", "$2,950.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@onclick = 'ConfirmOrder.save()']"));
        //Verify the Text “Thank You”
        verifyTextMessage("Unable to confirm order placed", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        //Verify the message “Your order has been successfully processed!”
        verifyTextMessage("Unable to confirm that order has been processed", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //Verify the text “Welcome to our store”
        verifyTextMessage("User is not taken back to the main store page","Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
