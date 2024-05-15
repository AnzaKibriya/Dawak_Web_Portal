package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static Helper.BaseClass.prescriptionOrderID;
import static Helper.BaseClass.test;

public class HomepageFrontLine {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Prescription#']")
    WebElement prescription;

    @FindBy(xpath = "//span[text()=' Search ']")
    WebElement search;


    public HomepageFrontLine(WebDriver Driver) {
        driver = Driver;
    }

    public  void searchrecord()
    {
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementInteractivity(prescription);
        prescription.sendKeys(prescriptionOrderID);
        search.click();
        test.log(Status.PASS, "Record searched successfully");


    }
}
