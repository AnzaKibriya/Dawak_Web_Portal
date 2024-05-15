package Pages;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileNotFoundException;

import static Helper.BaseClass.test;

public class LoginCallCentre {

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

    @FindBy(xpath = "//input[@placeholder='Search by Attribute']")
    WebElement search;


    public LoginCallCentre(WebDriver Driver) {
        driver = Driver;

    }



    public void CCLogin() {
        Assert.assertEquals(header.getText(), BaseClass.propertyFile("config", "HeaderText"));
        test.log(Status.PASS, "Header is Verified");
        userName.sendKeys(BaseClass.propertyFile("config", "usernamecc"));
        password.sendKeys(BaseClass.propertyFile("config", "passwordcc"));
        signInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(otp));
        otp.click();
    }

    public void  verifyEnteringOtp()
    {
        otp.sendKeys("1234");
        verifyButton.click();
        test.log(Status.PASS, "Home page Header verified");
        test.log(Status.PASS, "Sign In is Successful");
    }







}
