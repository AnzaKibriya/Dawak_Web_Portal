package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Helper.BaseClass.webJavascriptExecutor;
import static Helper.BaseClass.test;

public class Logout {
    WebDriver driver;

    public Logout(WebDriver Driver) {
        driver = Driver;
    }

    @FindBy(xpath = "//a//p[text()='Logout']")
    WebElement logoutButton;

    public void verifyLogout() {
        Pages.WebCommon().waitForLoaderInvisibility();
        webJavascriptExecutor().executeScript("arguments[0].click();", logoutButton);
        test.log(Status.PASS, " User Logout Out successfully");

    }
}
