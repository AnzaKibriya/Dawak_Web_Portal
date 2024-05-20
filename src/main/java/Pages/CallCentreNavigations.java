package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static Helper.BaseClass.test;
import static Helper.BaseClass.webJavascriptExecutor;

public class CallCentreNavigations {

    WebDriver driver;

    @FindBy(xpath = "//span[text()=' Completed ']")
    WebElement completed;

    public CallCentreNavigations(WebDriver Driver) {
        driver = Driver;
    }

    public void navigateToComplete() {

        webJavascriptExecutor().executeScript("arguments[0].click();", completed);
        test.log(Status.PASS, "Navigated to Completed Tab");    }

}
