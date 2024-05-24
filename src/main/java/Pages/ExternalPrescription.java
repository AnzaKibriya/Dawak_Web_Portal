package Pages;

import com.aventstack.extentreports.Status;
import org.checkerframework.checker.units.qual.K;
import org.json.XML;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Helper.BaseClass.test;
import static Helper.BaseClass.webJavascriptExecutor;
import static java.awt.event.KeyEvent.*;

public class ExternalPrescription {

    WebDriver driver;

    @FindBy(xpath = "(//canvas[@role='presentation'])[1]")
    WebElement Pdf1;

    @FindBy(xpath = "(//canvas[@role='presentation'])[2]")
    WebElement cardBackPdf;

    @FindBy(xpath = "(//canvas[@role='presentation'])[3]")
    WebElement prescriptionPdf;

    @FindBy(xpath = "//span[normalize-space()='Proceed']")
    WebElement proceedBtn;

    @FindBy(xpath = "//span[normalize-space()='Add Medication']")
    WebElement addAddressButton;

    @FindBy(xpath = "//input[@placeholder='Enter prescriber name']")
    WebElement prescriberName;

    @FindBy(xpath = "//app-add-medication-info//input[@placeholder='Enter Qty']")
    WebElement qty;

    @FindBy(xpath = "//app-add-medication-info//input[@placeholder='Enter Remaining Qty']")
    WebElement remainingQty;

    @FindBy(xpath = "//app-add-medication-info//input[@placeholder='Enter Refill Quantity']")
    WebElement refillQty;

    @FindBy(xpath = "//app-add-medication-info//input[@placeholder='Enter Days Supply']")
    WebElement daysSupply;

    @FindBy(xpath = "//app-add-medication-info//mat-label[text()='Health Plans']")
    WebElement healthPlan;

    @FindBy(xpath = "//span[normalize-space()='Co Pay']")
    WebElement coPay;

    @FindBy(xpath = "//app-add-medication-info//input[@placeholder='Enter Co-Pay Amount in AED']")
    WebElement coPayAmount;

    @FindBy(xpath = "//app-add-medication-info//textarea[@rows='5']")
    WebElement commentBox;

    @FindBy(xpath = "//app-add-medication-info//span[text()=' Save ']")
    WebElement saveButtons;

    @FindBy(xpath = "//span[normalize-space()='Task Complete']")
    WebElement taskComplete;

    @FindBy(xpath = "//button[@aria-label='OK']")
    WebElement okButton;

    @FindBy(xpath = "(//app-add-medication-info//mat-form-field)[last()]/div[contains(@class, 'mdc-text-field--filled')]")
    WebElement dosageInstruction;

    @FindBy(xpath ="//input[@id='mat-mdc-checkbox-4-input']")
    WebElement prescriptionCheckbox;

    @FindBy(xpath = "//span[normalize-space()='Re-Submit Order']")
    WebElement reSubmitButton;

    @FindBy(xpath ="//span[text()=' Submit']")
    WebElement submitButton;

    @FindBy(xpath ="//div[@class='mat-mdc-form-field-infix ng-tns-c3736059725-60']//textarea")
    WebElement resubmitOrderTextArea;

    String dosagetexts="//app-add-medication-info//input[@id='mat-input-21']";
    String dosageText="(//app-add-medication-info//mat-form-field)[last()]/div[contains(@class, 'mdc-text-field--focused')]";

    @FindBy(xpath = "//mat-option[@id='mat-option-634']//span[@class='mdc-list-item__primary-text'][normalize-space()='Montelukast chewable 5mg Tablet']")
    WebElement dosage;



    @FindBy(xpath = "//app-add-medication-info//span[text()='Med Description']")
    WebElement selectMedication;

    @FindBy(xpath = "//button[@aria-label='OK']")
    WebElement okBtn;

    @FindBy(xpath = "//div[@class='mdc-switch__shadow']")
    WebElement verifyButton;

    @FindBy(xpath = "//input[@placeholder='Number of medicines (In this file/ Image)*']")
    WebElement medicineNumber;

    @FindBy(xpath = "//i[@class='das das-save']")
    WebElement saveButton;

    public ExternalPrescription(WebDriver Driver) {
        driver = Driver;
    }

    public void verifyPdf() throws InterruptedException {
        Pdf1.click();
        webJavascriptExecutor().executeScript("arguments[0].click();", verifyButton);
        Pages.WebCommon().waitForLoaderInvisibility();
        cardBackPdf.click();
        webJavascriptExecutor().executeScript("arguments[0].click();", verifyButton);
        Pages.WebCommon().waitForLoaderInvisibility();
        prescriptionPdf.click();
        medicineNumber.sendKeys("1");
        webJavascriptExecutor().executeScript("arguments[0].click();", saveButton);
        Pages.WebCommon().waitForLoaderInvisibility();
        prescriptionPdf.click();
        webJavascriptExecutor().executeScript("arguments[0].click();", verifyButton);
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        test.log(Status.PASS, "All pdfs verified successfully");



    }

    public void proceed()  {
        proceedBtn.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        okBtn.click();
        Pages.WebCommon().waitForLoaderInvisibility();
        test.log(Status.PASS, "clicked ok button  successfully");


    }

    public void waitForAddAddress() throws InterruptedException {

        Thread.sleep(40000);
    }

    public void refresh() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(VK_SHIFT);
        Thread.sleep(1000);
        robot.keyPress(VK_R);
        test.log(Status.PASS, "Page refreshed successfully");
    }

    public void verifyAddAddress() throws AWTException, InterruptedException {
        Pages.WebCommon().waitForLoaderInvisibility();
        Actions action =  new Actions(driver);

        addAddressButton.click();
        test.log(Status.PASS, "clicked on Add address button  successfully");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        prescriberName.sendKeys("Laxman");
        webJavascriptExecutor().executeScript("arguments[0].click();", selectMedication);
       /*Robot robot=new Robot();
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);*/
        action.sendKeys(Keys.ENTER).build().perform();

        Pages.WebCommon().waitForElementsInteractions();
        qty.sendKeys("1");
        remainingQty.sendKeys("1");
        refillQty.sendKeys("1");
        daysSupply.sendKeys("1");
        Pages.WebCommon().waitForElementsInteractions();
        webJavascriptExecutor().executeScript("arguments[0].click();", healthPlan);
        coPay.click();
        coPayAmount.sendKeys("100");
        commentBox.sendKeys("Test");
        Pages.WebCommon().waitForElementsInteractions();




        //dosageInstruction.click();
       webJavascriptExecutor().executeScript("arguments[0].click();", dosageInstruction);
       // WebElement textField = driver.findElement(By.xpath(dosageInstruction  ));
        new Actions(driver).sendKeys(dosageInstruction, "DIS8W!").build().perform();

        // dosageText.sendKeys("DIS8W");
      //  webJavascriptExecutor().executeScript("arguments[0].value='DIS8W';", dosageInstruction);

       // robot.keyPress(KeyEvent.VK_TAB);
        saveButtons.click();
        test.log(Status.PASS, "Added address successfully");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        taskComplete.click();
        test.log(Status.PASS, "clicked on Task completed   successfully");
        okButton.click();
        Pages.WebCommon().waitForElementsInteractions();

    }

    public void selfPayPrescription()
    {
        reSubmitButton.click();
        prescriptionCheckbox.click();
        resubmitOrderTextArea.sendKeys("test");
        submitButton.click();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

}
