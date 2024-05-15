package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static Helper.BaseClass.webJavascriptExecutor;
import static java.awt.event.KeyEvent.*;

public class OrderDetailsFrontLine {

   WebDriver driver;

    @FindBy(xpath ="//span[normalize-space()='Accept Order']")
    WebElement acceptOrder;


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


    public void addAddress() throws InterruptedException, AWTException {
        acceptOrder.click();
        Pages.WebCommon().waitForElementsInteractions();
        switchButton.click();
        Pages.WebCommon().waitForElementsInteractions();
        searchLocation.sendKeys("Ain Al Faydah - Abu Dhabi - United Arab Emirates");
        Robot robot=new Robot();
        Pages.WebCommon().waitForElementsInteractions();
        robot.keyPress(VK_DOWN);
        Thread.sleep(2000);
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
