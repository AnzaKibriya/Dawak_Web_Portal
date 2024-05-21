package Pages;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.io.FileNotFoundException;
import java.security.cert.X509Certificate;
import java.util.List;

import static Helper.BaseClass.*;
import static Pages.WebCommon.*;
import static java.awt.event.KeyEvent.*;

public class HomePageCallCentre {

    WebDriver driver;


    String taskTableColumn = "//app-task-list//tbody[contains(@class, 'mdc-data-table__content')]//tr[1]//td";


    String taskTableHeading = "//app-task-list//table[contains(@class, 'mat-mdc-table mdc-data-table__table cdk-table mat-sort')]//th[%s]";

    String taskTableValues = "//app-task-list//tbody[contains(@class, 'mdc-data-table__content')]//td[%s]";

    @FindBy(xpath = "//input[@placeholder='Search by Attribute']")
    WebElement search;

    @FindBy(xpath = "//td[@class='mat-cell']")
    WebElement noRecordFoundText;

    @FindBy(xpath = "//app-callcenter-task-list//table//tbody//tr[1]//td[2]")
    WebElement taskName;


    @FindBy(xpath = "//tbody//tr[1]//img[1]")
    WebElement action;

    @FindBy(xpath = "//tbody//tr[1]//img[2]")
    WebElement details;


    @FindBy(xpath = "//img[@src='/assets/images/back-arrow.svg']")
    WebElement backArrow;

    public HomePageCallCentre(WebDriver Driver) {

        driver = Driver;

    }

    public void SearchForOrder(String orderid) throws InterruptedException, FileNotFoundException {
        Thread.sleep(3000);
        search.sendKeys(orderid);
        test.log(Status.PASS, "order searched successfully");

    }

    public void verifyCallBackRecord() {
        String tasktext = taskName.getText();
        Pages.WebCommon().assertJson(tasktext, "Pending Order Confirmation by User");
        test.log(Status.PASS, "Call me Back order is not present");

    }

    public void infos(WebElement element, WebElement actualText) {
        if (element.getText().contains("Task Name")) {
            if(actualText.getText().contains("Call me back")) {
                Pages.WebCommon().assertJson(actualText.getText(), BaseClass.propertyFile("config", "CallMeBackTaskName"));
                test.log(Status.PASS, "Task Name verified");
            }
            else if(actualText.getText().contains("Call for Consultation"))
            {
                Pages.WebCommon().assertJson(actualText.getText(), BaseClass.propertyFile("config", "CallMeBackTaskName"));
                test.log(Status.PASS, "Task Name verified");
            }
        } else if (element.getText().contains("Patient Name")) {

            Pages.WebCommon().assertJson(actualText.getText(), BaseClass.propertyFile("config", "FullNames"));
            test.log(Status.PASS, " Name verified");

        } else if (element.getText().contains("Task Created Date / Time")) {
            Pages.WebCommon().ExtractDateFromString(actualText.getText());
            getCurrentDateTime();
            Pages.WebCommon().assertJson(formattedDate, uiFormattedDate);
            test.log(Status.PASS, "created date text verified");

        }
        else if(element.getText().contains("Phone #"))
        {
            Pages.WebCommon().assertJson(actualText.getText(), mobileUserPhoneNumber);

        }


    }

    public Void searchForRecord() {
        search.sendKeys(fullName);
        test.log(Status.PASS, "order searched successfully");
        return null;
    }

    public void verifyNoRecordfoundText()
    {
       String noRecordText= noRecordFoundText.getText();
        Assert.assertEquals(noRecordText,"NO SUCH RECORD EXISTS");
        test.log(Status.PASS, "verified Record not found in Call Centre");

    }

    public void clickonDetails() {

        action.click();
        test.log(Status.PASS, "clicked on assign button successfully");


    }

    public void openOrderDetails() throws InterruptedException {
        Pages.WebCommon().waitForElementsInteractions();
        details.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        test.log(Status.PASS, "open order details page successfully");


    }

    public void refresh() throws AWTException, InterruptedException {

        Thread.sleep(60000);

        Robot robot = new Robot();
        robot.keyPress(VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(VK_SHIFT);
        Thread.sleep(1000);
        robot.keyPress(VK_R);
        test.log(Status.PASS, "Page refreshed successfully");


    }


    public void verifyTaskTable() throws FileNotFoundException {
        List<WebElement> taskDetailsTable = driver.findElements(By.xpath(taskTableColumn));
        System.out.println(taskDetailsTable.size());
        test.log(Status.PASS, "verifying task table information");

        for (int i = 1; i <= taskDetailsTable.size() - 1; i++) {
            WebElement tableHeading = driver.findElement(By.xpath(String.format(taskTableHeading, i)));
            WebElement tasktableData = driver.findElement(By.xpath(String.format(taskTableValues, i)));
            Pages.HomePageCallCentre().infos(tableHeading, tasktableData);

        }


    }


}
