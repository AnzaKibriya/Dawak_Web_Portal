package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Helper.BaseClass.test;

public class OrderDetailsAdmin {

    WebDriver driver;

    public OrderDetailsAdmin(WebDriver Driver) {
        driver = Driver;
    }


    @FindBy(xpath = "//span[normalize-space()='Cancel Order']")
    WebElement CancelButton;

    @FindBy(xpath = "//span[text()='Select an reason']")
    WebElement SelectReason;

    @FindBy(xpath = "//span[text()=' Changed my mind - غيرت رأيي ']")
    WebElement ChangedMyMind;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement SubmitButton;

    @FindBy(xpath = "//span[text()='Cancelled']")
    WebElement cancelled;


    public  void  cancelOrder()
    {
        CancelButton.click();
        SelectReason.click();
        ChangedMyMind.click();
        SubmitButton.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        test.log(Status.PASS, "Order cancelled successfully");

    }

    public void verifyCancelstatus()
    {

        String cancelText=cancelled.getText();
        Assert.assertEquals(cancelText,"Cancelled");
        test.log(Status.PASS, "Order cancelled text verified as expected");


    }

}
