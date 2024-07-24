package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Enum.CallCentreUserDetailsEnum;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import static Helper.BaseClass.test;
import static Helper.BaseClass.webJavascriptExecutor;
import static java.awt.event.KeyEvent.*;

public class OrderDetailsCallCentre {

    WebDriver driver;


    public String callCentreInfoSiblingstring = "//div[contains(text(), '%s')]/following-sibling::div";
    public String callCentrecInfostring = "//div[contains(text(), '%s')]";

    @FindBy(xpath = "//span[normalize-space()='Accept Order']")
    WebElement acceptOrder;


    @FindBy(xpath = "//button[@role='switch']")
    WebElement switchButton;

    @FindBy(xpath = "//input[@placeholder='Search Location']")
    WebElement searchLocation;

    @FindBy(xpath = "//mat-label[text()='Select Type']")
    WebElement selectType;

    @FindBy(xpath = "//mat-option//span[text()='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//span[text()='Add New']")
    WebElement addNewButton;

    @FindBy(xpath = "//button[@class='btn-green mr-20 mdc-button mdc-button--raised mat-mdc-raised-button _mat-animation-noopable mat-unthemed mat-mdc-button-base ng-star-inserted']//span[text()=' Proceed ']")
    WebElement proceedButton;

    @FindBy(xpath = "//span[text()=' Proceed ']")
    WebElement proceed;

    @FindBy(xpath ="//span[text()=' Accept Order ']")
    WebElement acceptOrders;

    @FindBy(xpath ="//span[text()=' Cancel Order ']")
    WebElement cancelOrder;

    @FindBy(xpath ="//span[text()=' Reject Order ']")
    WebElement rejectOrders;


    @FindBy(xpath ="//span[text()=' Cancel Order ']")
    WebElement cancelRejectOrders;

    @FindBy(xpath = "//button[@mattooltip='Place COD order on behalf of user']//span[text()=' Proceed ']")
    WebElement markAsCompleted;

    @FindBy(xpath = "//mat-select[@placeholder='Select Date']")
    WebElement selectDate;

    @FindBy(xpath = "//span[text()='Select time']")
    WebElement selectTime;

    @FindBy(xpath = "//span[normalize-space()='Did not respond']")
    WebElement didNotRespond;

    @FindBy(xpath ="//span[text()=' Reschedule Delivery ']")
    WebElement rescheduleDeliveryButton;


    @FindBy(xpath = "//span[text()=' Task Complete ']")
    WebElement taskCompleted;


    @FindBy(xpath = "//span[text()=' Reject Order ']")
    WebElement rejectOrder;

    @FindBy(xpath = "//span[text()='Select an reason']")
    WebElement rejectReason;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//span[text()='Patient Rejected']")
    WebElement patientRejected;

    @FindBy(xpath = "//span[normalize-space()='Reschedule Delivery']")
    WebElement rescheduleDelivery;

    @FindBy(xpath = "//span[text()='Select Date']")
    WebElement date;

    @FindBy(xpath = "//span[text()='Select time']")
    WebElement time;

    @FindBy(xpath = "//span[normalize-space()='Reschedule Now']")
    WebElement rescheduleNow;

    @FindBy(xpath = "//span[text()='Select Quantity']")
    WebElement Selectquantity;

    @FindBy(xpath = "//span[text()='1']")
    WebElement Quantity;

    @FindBy(xpath ="//span[text()=' Add Product ']")
    WebElement addProduct;


    public OrderDetailsCallCentre(WebDriver Driver) {

        driver = Driver;
    }


    public void verifyButtons()
    {
        Assert.assertEquals(didNotRespond.getText(),"Did not respond");
        Assert.assertEquals(taskCompleted.getText(),"Task Complete");
        Assert.assertEquals(acceptOrders.getText(),"Accept Order");
        Assert.assertEquals(rejectOrders.getText(),"Reject Order");
        test.log(Status.PASS, "successfully verified all buttons");
    }

    public void verifyButtonsDeliveryFailed()
    {
        Assert.assertEquals(rescheduleDeliveryButton.getText(),"Reschedule Delivery");
        Assert.assertEquals(didNotRespond.getText(),"Did not respond");
        Assert.assertEquals(cancelRejectOrders.getText(),"Cancel Order");
        test.log(Status.PASS, "successfully verified all buttons");


    }


    public void verifyButtonsAfterPayment()
    {
        Assert.assertEquals(didNotRespond.getText(),"Did not respond");
        Assert.assertEquals(taskCompleted.getText(),"Task Complete");
        Assert.assertEquals(proceed.getText(),"Proceed");
        Assert.assertEquals(cancelRejectOrders.getText(),"Cancel Order");
        test.log(Status.PASS, "successfully verified all buttons");

    }

    public void addAddress() throws InterruptedException, AWTException {
        acceptOrder.click();
        test.log(Status.PASS, "successfully clicked on accept order");
        Pages.WebCommon().waitForElementsInteractions();
        switchButton.click();
        Pages.WebCommon().waitForElementsInteractions();
        searchLocation.sendKeys("Ain Al Faydah - Abu Dhabi - United Arab Emirates");
        Robot robot = new Robot();
        Pages.WebCommon().waitForElementsInteractions();
        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
        selectType.click();
        homeButton.click();
        Pages.WebCommon().waitForElementsInteractions();
        test.log(Status.PASS, "address added successfully");
        addNewButton.click();
        test.log(Status.PASS, "clicked on add new button");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        proceed.click();
        test.log(Status.PASS, "clicked on proceed button");
    }


    public void rescheduleDelivery()
    {
        rescheduleDelivery.click();
        selectDate.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        selectTime.click();
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        rescheduleNow.click();

    }

    public void addProduct()
    {
        Selectquantity.click();
        Quantity.click();
        addProduct.click();
    }



    public void payment() throws InterruptedException, AWTException {
        Pages.WebCommon().waitForElementsInteractions();
        webJavascriptExecutor().executeScript("arguments[0].click();", markAsCompleted);
        test.log(Status.PASS, "clicked on mark as completed button successfully");
        Pages.WebCommon().waitForElementsInteractions();
        selectDate.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
        selectTime.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
        Pages.WebCommon().waitForLoaderInvisibility();
        webJavascriptExecutor().executeScript("arguments[0].click();", proceedButton);
        test.log(Status.PASS, "clicked on proceed button successfully");
    }


    public void response() throws AWTException {

        webJavascriptExecutor().executeScript("arguments[0].click();", didNotRespond);
        test.log(Status.PASS, "clicked on did not respond button successfully");


    }

    public void taskCompleted() {

        taskCompleted.click();
        test.log(Status.PASS, "clicked on taskCompleted  button successfully");


    }


    public void rejectOrder() throws AWTException, InterruptedException {

        rejectOrder.click();
        rejectReason.click();
        Robot robot = new Robot();
        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
        Pages.WebCommon().waitForElementsInteractions();
        submitButton.click();
        Pages.WebCommon().waitForLoaderInvisibility();

    }

    public void patientRejected() throws AWTException {
        String rejectedText = patientRejected.getText();
        Assert.assertEquals(rejectedText, "Patient Rejected");
        test.log(Status.PASS, "verify patient rejected");
    }


    public void verifyCallCentreUserDetailTable() {
        CallCentreUserDetailsEnum[] CallCentreUserDetailsEnums = CallCentreUserDetailsEnum.values();
        System.out.println(CallCentreUserDetailsEnums.length + "enum length");
        test.log(Status.PASS, "verifying Basic Details Information");
        for (int i = 0; i <= CallCentreUserDetailsEnums.length - 1; i++) {
            WebElement CallCentreUserInfo = driver.findElement(By.xpath(String.format(callCentrecInfostring, CallCentreUserDetailsEnums[i].value)));
            WebElement CallCentreUserSibling = driver.findElement(By.xpath(String.format(callCentreInfoSiblingstring, CallCentreUserDetailsEnums[i].value)));
            System.out.println(CallCentreUserInfo.getText());
            System.out.println(CallCentreUserSibling.getText());
            Pages.HomePageCallCentre().infos(CallCentreUserInfo, CallCentreUserSibling);
        }
    }


}
