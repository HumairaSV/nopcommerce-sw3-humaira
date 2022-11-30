package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualText = driver.findElement(by);
        return actualText.getText();
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);

    }

    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    public void selectFromAndClick(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);

        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }


    }

    public String verifyTextMessage(String message, String expected, By by) {
        String actual = driver.findElement(by).getText();
        Assert.assertEquals(message, expected, actual);
        return message;
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverAndNavigateToSubMenu(By by1, By by2) {
        Actions actions = new Actions(driver);
        WebElement ele1 = driver.findElement(by1);
        WebElement ele2 = driver.findElement(by2);
        actions.moveToElement(ele1).moveToElement(ele2).click().build().perform();
    }

    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(by);
        actions.moveToElement(ele).click().build().perform();
    }

    public void dragAndDrop(By by1, By by2) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(by1);
        WebElement droppable = driver.findElement(by2);
        actions.dragAndDrop(draggable, droppable);
    }

    public void sliderAction(By by, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(by);
        actions.dragAndDropBy(slider, x, y).build().perform();


    }

}
