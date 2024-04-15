package Pages;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.FileNotFoundException;

import static Helper.BaseClass.*;
import static Helper.BaseClass.webWait;

public class HomeDP {
    WebDriver driver;

    @FindBy(xpath = "//h2[text()='Dispensing Pharmacist Task List']")
    WebElement homePageHeader;
    @FindBy(xpath = "//*[@id='mat-tab-content-0-0']//tbody/tr/td[1]/span")
    WebElement encounterNumberTodoPage;
    @FindBy(xpath = "//input[@placeholder='Search by Attribute']")
    WebElement search;
    @FindBy(xpath = "//tr/td[2]")
    WebElement taskName;

    @FindBy(xpath = "//i[@mattooltip='Assign']")
    WebElement assignButton;


    @FindBy(xpath = "//*[@id='mat-tab-content-0-1']//tr[1]/td[1]/span")
    WebElement encounterNumberInProgressPage;


    @FindBy(xpath ="//app-dispencing-task-list//tbody/tr/td[1]/span")
    WebElement encounterNumberDispensingInProgressPage;

    @FindBy(xpath = "//i[@mattooltip='Detail']")
    WebElement detailButton;





    public HomeDP(WebDriver Driver) {
        driver=Driver;
    }
    public void verifyHomePageHeader() throws InterruptedException {
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Assert.assertEquals(homePageHeader.getText(), BaseClass.propertyFile("config", "HomepageHeaderDP"));
        test.log(Status.PASS, "Header is Verified");
    }

    public void SearchForOrder() throws InterruptedException, FileNotFoundException {
        Pages.WebCommon().waitForLoaderInvisibility();
        search.sendKeys(prescriptionOrderID);
        Pages.WebCommon().verifyDespensingTaskTable();
     //   Assert.assertEquals(encounterNumberTodoPage.getText(), prescriptionOrderID);
        //test.log(Status.PASS, "Encounter text verified in Todo Tab");
      //  Assert.assertEquals(taskName.getText(), BaseClass.propertyFile("config", "TaskNameDP"));
       // test.log(Status.PASS, "TaskName text Verified in Todo Tab");
     //   test.log(Status.PASS, "Order verified in TODO TAB");
    }


    public void clickonAssign()
    {
        webJavascriptExecutor().executeScript("arguments[0].click();", assignButton);
        test.log(Status.PASS, "successfully clicked on  assignButton");
        Pages.WebCommon().waitForLoaderInvisibility();

    }

    public void moveToInprogressandVerify() throws InterruptedException {
        Pages.WebCommon().waitForLoaderInvisibility();
        webWait.until(ExpectedConditions.visibilityOf(encounterNumberInProgressPage));
        search.sendKeys(prescriptionOrderID);
        Assert.assertEquals(encounterNumberDispensingInProgressPage.getText(), prescriptionOrderID);
        test.log(Status.PASS, "Encounter text verified in Inprogress tab");
        Assert.assertEquals(taskName.getText(), BaseClass.propertyFile("config", "TaskNameDP"));
        test.log(Status.PASS, "TaskName text Verified in Inprogress tab");
    }

    public void clickonDetailButtonInInprogressTab()
    {
        webJavascriptExecutor().executeScript("arguments[0].click();", detailButton);
        test.log(Status.PASS, "clicked on Inprogress tab detailed button");


    }


    public void searchOrderInDispensingInProgress() throws InterruptedException {
        Pages.WebCommon().waitForLoaderInvisibility();
        Thread.sleep(2000);
        search.sendKeys(prescriptionOrderID);
    }

    public void clickDetailButtonInDispensingInprogress()
    {
        webJavascriptExecutor().executeScript("arguments[0].click();", detailButton);
        test.log(Status.PASS, "clicked detailed button in despensing Inprogress");


    }
}