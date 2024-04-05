import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestDawakDP extends BaseClass {

    @Test(priority = 21)
    public void verifyDPLogin() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();


    }

    @Test(priority = 22)
    public void verifyOrderInTOdoDespensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
    }



    @Test(priority =23 )
    public void clickOnAssign()
    {
        test = extent.createTest("click on assign button on detail page");
        Pages.HomeDP().clickonAssign();


    }

    @Test(priority = 24)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }

    @Test(priority =25)

    public void verifypatientInformation() throws FileNotFoundException {
        test = extent.createTest("Verify patientInformation");
        Pages.PatientInformations().verifyBasicDetailTable();
        Pages.PatientInformations().verifyContactDetail();
        Pages.PatientInformations().userDetails();
        Pages.OrderDetailsDP().addressDetailsTable();
        Pages.OrderDetailsDP().verifyDeliveryDetail();
        Pages.OrderDetailsDP().pendingMedicationTableDp();


    }

 /*  @Test(priority = 25)
    public void verifyInprogressData() throws FileNotFoundException {
        test = extent.createTest("Verify InProgress column Data");
       // Pages.WebCommon().verifyWebTableData();
        Pages.WebCommon().verifyDespensingTaskTable();



    }*/

    @Test(priority = 26)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();
        Pages.OrderDetailsDP().orderReadyForDelivery();

    }

    @Test(priority = 27)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);

    }
    @Test(priority = 28)
    public void verifyLogoutFunctionalityDespensing() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 29)
    public void verifyOutforDelivery() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();
        Thread.sleep(4000);
        Pages.Dispatched().OutForDeliveryFunctionality();

    }
}