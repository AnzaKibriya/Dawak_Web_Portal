package Pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.lang.model.type.NullType;
import java.awt.*;

import static Helper.BaseClass.webJavascriptExecutor;
import static java.awt.event.KeyEvent.*;

public class OrderDetailsFrontLine {

   WebDriver driver;

    @FindBy(xpath ="//span[normalize-space()='Accept Order']")
    WebElement acceptOrder;

    @FindBy(xpath = "//label[text()='Product Information ']")
    WebElement productInformation;


    @FindBy(xpath = "//button[@role='switch']")
    WebElement switchButton;

    @FindBy(xpath ="//input[@placeholder='Search Location']")
    WebElement searchLocation;

    @FindBy(xpath = "//mat-label[text()='Select Type']")
    WebElement selectType;

    @FindBy(xpath = "//mat-option//span[text()='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//span[text()=' Add new ']")
    WebElement addNewButton;

    @FindBy(xpath = "//span[text()=' Proceed ']")
    WebElement proceedButton;

    @FindBy(xpath = "//span[text()=' Mark as Completed ']")
    WebElement markAsCompleted;

    @FindBy(xpath = "//mat-select[@placeholder='Select Date']")
    WebElement selectDate;

    @FindBy(xpath = "//span[text()='Select time']")
    WebElement selectTime;

    @FindBy(xpath = "//div[@id='ChIJawPMN2a7ij4RNW3oq631F0s']//span[@class='pac-matched'][normalize-space()='Ain Al Faydah']")
    WebElement tab;



    public OrderDetailsFrontLine(WebDriver Driver) {

        driver = Driver;
    }


    public void verifyProductInformation() {
        try {
            Assert.assertEquals(productInformation.getText(), "Product Information");


        } catch (NoSuchElementException e) {
            // Handle the exception (element not found)
            System.out.println("Element not found: " + e.getMessage());
        }
    }


    public void addAddress() throws InterruptedException, AWTException {
        acceptOrder.click();
        Pages.WebCommon().waitForElementsInteractions();
        switchButton.click();
        Pages.WebCommon().waitForElementsInteractions();
        searchLocation.sendKeys("Ain Al Faydah - Abu Dhabi - United Arab Emirates");
        Robot robot=new Robot();
        robot.keyPress(VK_UP);
        Pages.WebCommon().waitForElementsInteractions();
        Thread.sleep(2000);
        robot.keyPress(VK_DOWN);
        Pages.WebCommon().waitForElementsInteractions();
        //  webJavascriptExecutor().executeScript("arguments[0].click();", tab);
       // robot.keyPress(VK_TAB);
      //  robot.keyRelease(VK_TAB);
        selectType.click();
        homeButton.click();
        Pages.WebCommon().waitForElementsInteractions();
      webJavascriptExecutor().executeScript("window.scrollBy(0,500)");
        addNewButton.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        proceedButton.click();

    }

}
