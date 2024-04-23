package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.FileNotFoundException;

import static Helper.BaseClass.test;
import static Helper.BaseClass.webJavascriptExecutor;

public class Dispatched {


    WebDriver driver;

    @FindBy(xpath = "//span[text()=' Dispatched ']")
    WebElement dispatched;
    @FindBy(xpath = "//i[@mattooltip='Detail']")
    WebElement details;

    @FindBy(xpath = "//span[text()='Delivered']")
    WebElement deliverytext;

    public Dispatched(WebDriver Driver) {
        driver = Driver;
    }


    public void OutForDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        webJavascriptExecutor().executeScript("arguments[0].click();", dispatched);
        Pages.WebCommon().waitForLoaderInvisibility();//waiting for loader
        Pages.HomeDP().SearchForOrder();// searching for sepecific order
        Pages.WebCommon().waitForLoaderInvisibility();
        details.click();//clicking on detailed button
        test.log(Status.PASS, "click on detailed button in Dispatched ");
        Pages.WebCommon().waitForLoaderInvisibility();
        Assert.assertEquals(deliverytext.getText(),"Delivered");
        test.log(Status.PASS, "order de;ivery status verified");





        // opening ready for delivery tab


    }
}
