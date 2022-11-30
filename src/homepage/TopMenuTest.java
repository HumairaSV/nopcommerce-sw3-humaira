package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;
import java.util.Scanner;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    String menuName = "Computers";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }

    public void selectMenu(String menu) {
        if (menu.equalsIgnoreCase("computers")) {
            clickOnElement(By.linkText("Computers"));
            String expectedText = "Computers";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Computers']"));
            Assert.assertEquals("Not navigated to the selected menu", expectedText, actualText);
        } else if (menu.equalsIgnoreCase("electronics")) {
            clickOnElement(By.linkText("Electronics"));
            String expectedText = "Electronics";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Electronics']"));
            Assert.assertEquals("Not navigated to the Electronics menu", expectedText, actualText);
        } else if (menu.equalsIgnoreCase("apparel")) {
            clickOnElement(By.linkText("Apparel"));
            String expectedText = "Apparel";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Apparel']"));
            Assert.assertEquals("Not navigated to the Apparel menu", expectedText, actualText);
        } else if (menu.equalsIgnoreCase("digital downloads")) {
            clickOnElement(By.linkText("Digital downloads"));
            String expectedText = "Digital downloads";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Digital downloads']"));
            Assert.assertEquals("Not navigated to the Digital downloads menu", expectedText, actualText);
        } else if (menu.equalsIgnoreCase("books")) {
            clickOnElement(By.linkText("Books"));
            String expectedText = "Books";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Books']"));
            Assert.assertEquals("Not navigated to the Books menu", expectedText, actualText);
        } else if (menu.equalsIgnoreCase("Jewelry")) {
            clickOnElement(By.linkText("Jewelry"));
            String expectedText = "Jewelry";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Jewelry']"));
            Assert.assertEquals("Not navigated to the Jewelry menu", expectedText, actualText);
        } else if (menu.equalsIgnoreCase("gift cards")) {
            clickOnElement(By.linkText("Gift Cards"));
            String expectedText = "Gift Cards";
            String actualText = getTextFromElement(By.xpath("//div[@class = 'page-title']/h1[text() = 'Gift Cards']"));
            Assert.assertEquals("Not navigated to the gift cards menu", expectedText, actualText);
        }
    }

    @Test
    //input the menuName you want to test @line no 18
    public void verifyPageNavigation(){
        selectMenu(menuName);
    }

    @After
    public void tearDown(){
       closeBrowser();
    }
}







