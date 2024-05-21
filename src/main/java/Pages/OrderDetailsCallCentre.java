package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import Enum.CallCentreUserDetailsEnum;
import org.testng.Assert;

import java.awt.*;
import java.io.FileNotFoundException;

import static Helper.BaseClass.test;
import static java.awt.event.KeyEvent.*;

public class OrderDetailsCallCentre {

    WebDriver driver;


    public String callCentreInfoSiblingstring = "//div[contains(text(), '%s')]/following-sibling::div";
    public String callCentrecInfostring="//div[contains(text(), '%s')]";

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

    @FindBy(xpath = "//span[text()=' Proceed ']")
    WebElement proceedButton;

    @FindBy(xpath = "//span[text()=' Mark as Completed ']")
    WebElement markAsCompleted;

    @FindBy(xpath = "//mat-select[@placeholder='Select Date']")
    WebElement selectDate;

    @FindBy(xpath = "//span[text()='Select time']")
    WebElement selectTime;

    @FindBy(xpath = "//span[normalize-space()='Did not respond']")
    WebElement didNotRespond;


    @FindBy(xpath = "//span[normalize-space()='Task Completed']")
    WebElement taskCompleted;


    @FindBy(xpath = "//span[text()=' Reject Order ']")
    WebElement rejectOrder;

    @FindBy(xpath = "//span[text()='Select an reason']")
    WebElement rejectReason;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//span[text()='Patient Rejected']")
    WebElement patientRejected;




    public OrderDetailsCallCentre(WebDriver Driver) {

        driver = Driver;
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
        proceedButton.click();
        test.log(Status.PASS, "clicked on proceed button");
    }


    public void payment() throws InterruptedException, AWTException {
        Pages.WebCommon().waitForElementsInteractions();
        markAsCompleted.click();
        test.log(Status.PASS, "clicked on mark as completed button successfully");
        Pages.WebCommon().waitForElementsInteractions();
        selectDate.click();
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(VK_DOWN);
        Thread.sleep(1000);
        robot.keyPress(VK_DOWN);
        Thread.sleep(1000);
        robot.keyPress(VK_ENTER);
        selectTime.click();
        Thread.sleep(2000);
        robot.keyPress(VK_DOWN);
        Thread.sleep(1000);
        robot.keyPress(VK_DOWN);
        Thread.sleep(1000);
        robot.keyPress(VK_ENTER);
        Pages.WebCommon().waitForLoaderInvisibility();
        proceedButton.click();
        test.log(Status.PASS, "clicked on proceed button successfully");
    }


    public void response() {

        didNotRespond.click();
        test.log(Status.PASS, "clicked on did not respond button successfully");


    }

    public void taskCompleted() {

        taskCompleted.click();
        test.log(Status.PASS, "clicked on taskCompleted  button successfully");


    }


    public void rejectOrder() throws AWTException {

        rejectOrder.click();
        rejectReason.click();
        Robot robot = new Robot();
        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
        submitButton.click();
        Pages.WebCommon().waitForLoaderInvisibility();

    }

    public void patientRejected() throws AWTException {
       String rejectedText= patientRejected.getText();
        Assert.assertEquals(rejectedText,"Patient Rejected");
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
