package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static Helper.BaseClass.test;
import static java.awt.event.KeyEvent.*;

public class OrderDetailsCallCentre {

    WebDriver driver;

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
        Robot robot = new Robot();
        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
        selectTime.click();
        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
        Pages.WebCommon().waitForLoaderInvisibility();
        proceedButton.click();
        test.log(Status.PASS, "clicked on proceed button successfully");

    }
}
