package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

import static Helper.BaseClass.test;

public class HomePageCallCentre {

    WebDriver driver;


    @FindBy(xpath = "//input[@placeholder='Search by Attribute']")
    WebElement search;

    public HomePageCallCentre(WebDriver Driver) {

        driver = Driver;

    }

    public void SearchForOrder(String orderid) throws InterruptedException, FileNotFoundException {
        Thread.sleep(3000);
        search.sendKeys(orderid);
        test.log(Status.PASS, "order searched successfully");

    }
}
