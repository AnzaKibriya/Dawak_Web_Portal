package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

import static Helper.BaseClass.*;

public class HomePageAdmin {

    WebDriver driver;

    public HomePageAdmin(WebDriver Driver) {
        driver = Driver;
    }

    @FindBy(xpath = "//i[@class='das das-order-icon']")
    WebElement orderIcon;

    @FindBy(xpath = "//a[text()=' All Orders']/following-sibling::a[2]")
    WebElement dispensingOrders;

    @FindBy(xpath = "//a[normalize-space()='All Orders']")
    WebElement allOrders;

    @FindBy(xpath ="//button[normalize-space()='Filter']")
    WebElement filter;

    @FindBy(xpath = "//h5[normalize-space()='Order Information']")
    WebElement orderInformation;

    @FindBy(xpath = "//input[@formcontrolname='orderId']")
    WebElement orderTitle;

    @FindBy(xpath = "//span[normalize-space()='Apply']")
    WebElement applyButton;

    @FindBy(xpath = "//img[@mattooltip='Details']")
    WebElement detailedIcon;

    @FindBy(xpath = "//i[@mattooltip='Detail']")
    WebElement detailIcon;

    @FindBy(xpath ="//i[@Class='das das-cross brand-image-xs logo-xl icon-width']")
    WebElement crosslogo;

    @FindBy(xpath = "//span[text()='Select a Pharmacist']")
    WebElement pharmacist;

    @FindBy(xpath = "//div[@role='listbox'] //span[text()=' Laxman  cp ']")
    WebElement Location;

    @FindBy(xpath = "//span[text()=' Laxman Call Centre ']")
    WebElement LocationCallCentre;

    @FindBy(xpath ="//div[@role='listbox']//span[text()=' Laxman  dp ']")
    WebElement LocationDispensing;

    @FindBy(xpath = "//a[@href='#/oms/centralpharma-order-list']\n")
    WebElement centralpharmaOrderList;

    @FindBy(xpath = "//i[@class='das das-btn-tick']")
    WebElement orderSubmitButton;

    @FindBy(xpath = "//i[@mattooltip='Assign']")
    WebElement assignButton;



    public void allOrders()
    {
        orderIcon.click();
        allOrders.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        webJavascriptExecutor().executeScript("arguments[0].click();", crosslogo);
        test.log(Status.PASS, " clicked on All orders successfully");
    }


    public void selectingPharmaCist()
    {
        pharmacist.click();
        Location.click();
        orderSubmitButton.click();
        test.log(Status.PASS, " successfully selected pharmacist");

    }



    public void selectingPharmaCistCallCentre()
    {
        pharmacist.click();
        LocationCallCentre.click();
        orderSubmitButton.click();
        test.log(Status.PASS, " successfully selected pharmacist");
    }

    public void selectingPharmacistDispensing()
    {
        pharmacist.click();
        LocationDispensing.click();
        orderSubmitButton.click();

    }
    public void CentralpharmaOrderListOrders()
    {
        orderIcon.click();
        centralpharmaOrderList.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        crosslogo.click();
        test.log(Status.PASS, " clicked on All orders successfully");
    }
    public void dispensingOrders()
    {
        orderIcon.click();
        dispensingOrders.click();
        Pages.WebCommon().waitForLoaderInvisibility();
       crosslogo.click();
        test.log(Status.PASS, " clicked on All orders successfully");


    }



    public void searchUsingFilters() throws InterruptedException {

        webJavascriptExecutor().executeScript("arguments[0].click();", filter);
        Pages.WebCommon().waitForElementsInteractions();
        orderInformation.click();
        orderTitle.sendKeys(prescriptionOrderID);
        webJavascriptExecutor().executeScript("arguments[0].click();", applyButton);
        Pages.WebCommon().waitForLoaderInvisibility();
        test.log(Status.PASS, " Order searched successfully using Filters");

    }

    public void moveToDetailedPage()
    {
        detailedIcon.click();
        test.log(Status.PASS, " move to detailed page");

    }

    public void moveToDetailedPageDispensing()
    {
        detailIcon.click();
        test.log(Status.PASS, " move to detailed page");

    }

    public void assignButtonDispensing()
    {
        assignButton.click();
        test.log(Status.PASS, "clicked on Assign button successfully");

    }
}
