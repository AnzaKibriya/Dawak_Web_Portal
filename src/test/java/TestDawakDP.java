import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestDawakDP extends BaseClass {

    @Test(priority = 1)
    public void verifyDPLogin() throws InterruptedException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();

    }

    @Test(priority = 2)
    public void verifyOrderInTOdoDespensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
        Pages.HomeDP().clickonAssign();
    }

    @Test(priority = 3)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }

    @Test(priority =4)

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

    @Test(priority = 5)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();

    }
    @Test(priority =6)
    public void verifypatientInformations() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify patientInformation");
        Pages.PatientInformations().verifyBasicDetailTable();
        Pages.PatientInformations().verifyContactDetail();
        Pages.PatientInformations().userDetails();
        Pages.OrderDetailsDP().addressDetailsTable();
        Pages.OrderDetailsDP().verifyDeliveryDetail();
        Pages.OrderDetailsDP().pendingMedicationTableDp();
        Pages.OrderDetailsDP().orderReadyForDelivery();


    }

    @Test(priority = 7)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);

    }
    @Test(priority = 8)
    public void verifyLogoutFunctionalityDespensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Thread.sleep(2000);
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 9)
    public void verifyOutforDelivery() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();
        Thread.sleep(4000);
        Pages.Dispatched().OutForDeliveryFunctionality();
        Thread.sleep(3000);
    }
    @Test(priority = 10)
    public void verifyLogoutAfterDispatchedFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }
}