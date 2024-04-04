package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Helper.BaseClass.webJavascriptExecutor;
import static Helper.BaseClass.test;

public class OrderDetailsDP {

    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Dispensing Started']")
    WebElement dispencingOrder;

    @FindBy(xpath = "//span[text()=' Ready For Delivery ']")
    WebElement readyForDelivery;

    @FindBy(xpath = "//button//img[@src='/assets/images/btn-tick.svg']")
    WebElement yesButton;

    @FindBy(xpath = "//span[text()='New Prescription']")
    WebElement newPrescriptionText;

    public OrderDetailsDP(WebDriver Driver) {
        driver = Driver;
    }


    public void dispensingOrder() throws InterruptedException {
        Pages.WebCommon().waitForLoaderInvisibility();
        try {
            Pages.WebCommon().waitForElementsInteractions();
            webJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", dispencingOrder);
            dispencingOrder.click();
            test.log(Status.PASS, "clicked on Despensing started");


        } catch (StaleElementReferenceException e) {
        }

        Pages.WebCommon().waitForLoaderInvisibility();
        test.log(Status.PASS, "Navigated to Detail page and clicked on Despencing started");
    }

    public void orderReadyForDelivery() throws InterruptedException {
       Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        webJavascriptExecutor().executeScript("arguments[0].click();", readyForDelivery);
       webJavascriptExecutor().executeScript("arguments[0].click();", yesButton);
        test.log(Status.PASS, "Navigated to Detail page and clicked on  Ready for Delivery");
    }
}