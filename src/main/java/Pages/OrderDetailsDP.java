package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.List;
import  Enum.DeliveryDetailsEnum;

import static Helper.BaseClass.webJavascriptExecutor;
import static Helper.BaseClass.test;

public class OrderDetailsDP {

    WebDriver driver;


    String pendingMedicationTableRowdp="//app-dispensing-medication-info//tbody[contains(@class, 'mdc-data-table__content')]//tr";

    String pendingMedicationColumndp="//app-dispensing-medication-info//table[contains(@class, 'mat-mdc-table mdc-data-table__table cdk-table mat-sort mat-elevation-z8')]//th";

    String pendingMedicationTableDatadp="//app-dispensing-medication-info//tbody[contains(@class, 'mdc-data-table__content')]//tr[%s]//td[%s]";

    String pendingMedicationTableHeadingdp="//app-dispensing-medication-info//table[contains(@class, 'mat-mdc-table mdc-data-table__table cdk-table mat-sort mat-elevation-z8')]//th[%s]";

    public String deliveryInfostring="//h5[contains(text(), '%s')]";

    public String deliveryInfoSiblingstring = "//h5[contains(text(), '%s')]/following-sibling::h5";


    String deliveryDetailsHeader="//app-address-detail//table[contains(@class, 'mat-mdc-table mdc-data-table__table cdk-table mat-sort mat-elevation-z8')]//th[%s]";

    String deliveryDetailsrow="//app-address-detail//tbody[contains(@class, 'mdc-data-table__content')]//tr";

    String deliveryDetailsColumn="//app-address-detail//table[contains(@class, 'mat-mdc-table mdc-data-table__table cdk-table mat-sort mat-elevation-z8')]//th";


    String deliveryDetailsTable="//app-address-detail//tbody[contains(@class, 'mdc-data-table__content')]//tr[%s]//td[%s]";

    @FindBy(xpath = "//span[normalize-space()='Dispensing Started']")
    WebElement dispencingOrder;

    @FindBy(xpath = "//span[text()=' Ready For Delivery ']")
    WebElement readyForDelivery;

    @FindBy(xpath = "//button//img[@src='/assets/images/btn-tick.svg']")
    WebElement yesButton;

    @FindBy(xpath = "//span[text()='New Prescription']")
    WebElement newPrescriptionText;

    @FindBy(xpath = "//span[text()=' Confirm Failed Delivery ']")
    WebElement confirmFailedDelivery;



    public OrderDetailsDP(WebDriver Driver) {
        driver = Driver;
    }


    public void dispensingOrder() throws InterruptedException {
        Pages.WebCommon().waitForLoaderInvisibility();
        try {
            Pages.WebCommon().waitForElementsInteractions();
            webJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", dispencingOrder);
            dispencingOrder.click();
            test.log(Status.PASS, "clicked on Despensing started");


        } catch (StaleElementReferenceException e) {
        }

        Pages.WebCommon().waitForLoaderInvisibility();
        test.log(Status.PASS, "Navigated to Detail page and clicked on Despencing started");
    }

    public void orderReadyForDelivery() throws InterruptedException {
       Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        webJavascriptExecutor().executeScript("arguments[0].click();", readyForDelivery);
       webJavascriptExecutor().executeScript("arguments[0].click();", yesButton);
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        test.log(Status.PASS, "Navigated to Detail page and clicked on  Ready for Delivery");
    }


    public void verifyDeliveryDetail() {
        DeliveryDetailsEnum[] deliveryDetailsEnums = DeliveryDetailsEnum.values();
        for (int i = 0; i <= deliveryDetailsEnums.length - 1; i++) {
            WebElement deliveryDetails = driver.findElement(By.xpath(String.format(deliveryInfostring, deliveryDetailsEnums[i].value)));
            WebElement deliverySibling = driver.findElement(By.xpath(String.format(deliveryInfoSiblingstring, deliveryDetailsEnums[i].value)));

            try {
                Pages.PatientInformations().info(deliveryDetails,deliverySibling);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

    }


    public void cancelFailedOrder()
    {

        confirmFailedDelivery.click();
    }



    public void pendingMedicationTableDp() throws FileNotFoundException {
        List<WebElement> pendingMedicationdprowSize = driver.findElements(By.xpath(pendingMedicationTableRowdp));
        List<WebElement> pendingMedicationdpColumnSize = driver.findElements(By.xpath(pendingMedicationColumndp));
        for(int i=1;i<=pendingMedicationdprowSize.size();i++)
        {
            for(int j=1;j<=pendingMedicationdpColumnSize.size();j++)
            {
                WebElement medicationHeader=driver.findElement(By.xpath(String.format(pendingMedicationTableHeadingdp,j)));
                WebElement medicationDetails=driver.findElement(By.xpath(String.format(pendingMedicationTableDatadp,i,j)));
                System.out.println(medicationDetails.getText());
                Pages.PatientInformations().info(medicationHeader,medicationDetails);
            }
        }


    }




    public void addressDetailsTable() throws FileNotFoundException {
        List<WebElement> deliveryDetailsrowSize = driver.findElements(By.xpath(deliveryDetailsrow));
        System.out.println(deliveryDetailsrowSize.size());
        List<WebElement> deliveryDetailsColumnSize = driver.findElements(By.xpath(deliveryDetailsColumn));
        System.out.println(deliveryDetailsColumnSize.size());
        for(int i=1;i<=deliveryDetailsrowSize.size();i++)
        {
            for(int j=1;j<=deliveryDetailsColumnSize.size();j++)
            {
                WebElement deliveryDetailsHeadesr=driver.findElement(By.xpath(String.format(deliveryDetailsHeader,j)));
                WebElement deliveryDetails=driver.findElement(By.xpath(String.format(deliveryDetailsTable,i,j)));
                System.out.println(deliveryDetails.getText());
               Pages.PatientInformations().info(deliveryDetailsHeadesr,deliveryDetails);
            }
        }


    }

}