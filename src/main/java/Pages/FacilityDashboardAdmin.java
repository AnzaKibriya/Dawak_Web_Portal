package Pages;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Helper.BaseClass.test;
import static Helper.BaseClass.webJavascriptExecutor;

public class FacilityDashboardAdmin {

    WebDriver driver;

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//h1")
    WebElement header;
    @FindBy(className = "btn-custom-primary")
    WebElement signInButton;
    @FindBy(xpath = "//div//div[@aria-label='Invalid credentials. Please Login Again']")
    WebElement InvalidLoginErrorMessage;
    @FindBy(name = "otp")
    WebElement otp;
    @FindBy(xpath = "//button[text()='Verify']")
    WebElement verifyButton;

    @FindBy(xpath = "//img[@src='../../../../assets/images/menu-down-arrow.svg']")
    WebElement facilityDropdown;

    @FindBy(xpath = "//span[text()='Facility Dashboard']")
    WebElement facilityDashboard;

    @FindBy(xpath = "//a[@href='#/oms/dispensingpharma-order-list'and @routerlinkactive]")
    WebElement dispensingpharmaOrder;

    @FindBy(xpath = "//input[@placeholder='Search by Attribute']")
    WebElement search;

    @FindBy(xpath = "//i[@class='das das-cross brand-image-xs logo-xl icon-width']")
    WebElement backButton;
    public FacilityDashboardAdmin(WebDriver Driver) {

        driver=Driver;
    }


    public void LoginFacilityDashboardAdmin() {
        Assert.assertEquals(header.getText(), BaseClass.propertyFile("config", "HeaderText"));
        test.log(Status.PASS, "Header is Verified");
        userName.sendKeys(BaseClass.propertyFile("config", "UsernameFacilityDashboard"));
        password.sendKeys(BaseClass.propertyFile("config", "passwordCallCentreAdmin"));
        signInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(otp));
        otp.click();
    }

    public void facilityDespensingDropDown()
    {
        webJavascriptExecutor().executeScript("arguments[0].click();", facilityDashboard);
        webJavascriptExecutor().executeScript("arguments[0].click();", dispensingpharmaOrder);
        webJavascriptExecutor().executeScript("arguments[0].click();", backButton);
    }


}
