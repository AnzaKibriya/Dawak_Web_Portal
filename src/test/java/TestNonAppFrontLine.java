import APICalls.LoginApiCall;
import APICalls.NonAppFrontLineDeliveryAPICall;
import APICalls.NonAppHomeDeliveryAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestNonAppFrontLine extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        NonAppFrontLineDeliveryAPICall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
    }
    @Test(priority =2)
    public void LoginFrontLine() throws InterruptedException {
        test = extent.createTest("Login Front Line Pharmacist");
        Pages.LoginFrontLine().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Thread.sleep(7000);
    }
    @Test(priority = 3)
    public void verifysearch() throws InterruptedException {
        test = extent.createTest("search for the order");
        Pages.HomepageFrontLine().searchrecord();
    }
    @Test(priority = 4)
    public void verifyMoveToOrderDetailscc() throws InterruptedException, AWTException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.OrderDetailsFrontLine().addAddress();
        Thread.sleep(3000);
    }
    @Test(priority = 5)
    public void verifyLogoutccFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 6)
    public void verifyCPLogin() throws IOException, InterruptedException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().invalidCPLogin();
        Pages.LoginCP().CPLogin();
//        Pages.Mailinator().verifyOtp();
        Pages.LoginCP().verifyEnteringOtp();

    }


    @Test(priority = 7)
    public void verifyFilterValidation() throws InterruptedException, FileNotFoundException {

        test = extent.createTest("Verify Filter Validation");
        Pages.WebCommon().waitForElementsInteractions();
       // Pages.Home().verifyFilters();

    }

    @Test(priority = 8)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }

    @Test(priority = 9)
    public void verifyTodoColumnData() throws FileNotFoundException {
        test = extent.createTest("Verify Data present in Todo  column");
        Pages.Home().verifyDataInWebTable();

    }

    @Test(priority = 10)
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.NavigationsCP().moveToNewPrescription();
        Pages.Home().clearSearch();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 11)
    public void verifyInProgressColumnData() throws FileNotFoundException {
        test = extent.createTest("Verify Data present in  In-progress column");
        Pages.Home().verifyDataInWebTable();
        //  Pages.WebCommon().verifyTaskTable();

    }

    @Test(priority = 12)
    public void verifyUnAssignFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify un-assign functionality");
        Pages.Home().verifyReAssign();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority =13)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    }
    @Test(priority = 14)
    public void verifyPatientInformation() throws FileNotFoundException {
        test = extent.createTest("Verify patient information in orderDetails page ");
        //  Pages.PatientInformations().verifyBasicDetailTable();
        //Pages.PatientInformations().verifyContactDetail();
        // Pages.PatientInformations().userDetails();
        Pages.PatientInformations().pendingMedicationTable();
    }
    @Test(priority = 15)
    public void verifyOrderDetails() throws FileNotFoundException {
        test = extent.createTest("Verify order details data and Header text ");
        Pages.OrderDetails().verifyDeliveryDetailTable();
        Pages.OrderDetails().verifyOrderDetailTable();
        Pages.OrderDetails().verifyOrderDetailsHeader();
        Pages.OrderDetails().verifyTrackDetailTable();
//        Pages.OrderDetails().verifyViewDetailsInformation();
        Pages.OrderDetails().verifyRemoveFunctionality();
    }

    @Test(priority = 16)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingCopay();
    }

    @Test(priority = 17)
    public void verifyLogoutFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
    }

    @Test(priority =18)
    public void Logincallcentre() throws InterruptedException {
        test = extent.createTest("Logincc");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Thread.sleep(7000);
    }


    @Test(priority = 19)
    public  void Homepagecallcentre() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Home page call centre");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority =20 )
    public  void moveTOorderDetails() throws InterruptedException {
        test = extent.createTest("Move to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
    }


    @Test(priority = 21)
    public void Completeorder() throws InterruptedException, AWTException {
        test = extent.createTest("complete order ");
        Pages.OrderDetailsCallCentre().payment();
        Thread.sleep(10000);

    }
    @Test(priority = 22)
    public void verifyLogoutcallcentreFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 23)
    public void verifyDPLogin() throws InterruptedException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        // Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();

    }

    @Test(priority = 24)
    public void verifyOrderInTOdoDespensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
        Pages.HomeDP().clickonAssign();
    }

    @Test(priority = 25)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }

    @Test(priority =26)

    public void verifypatientInformation() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify patientInformation");
        Thread.sleep(4000);
        // Pages.PatientInformations().verifyBasicDetailTable();
        //  Pages.PatientInformations().verifyContactDetail();
        //  Pages.PatientInformations().userDetails();
        // Pages.OrderDetailsDP().addressDetailsTable();
        // Pages.OrderDetailsDP().verifyDeliveryDetail();
        Pages.OrderDetailsDP().pendingMedicationTableDp();

    }

 /*  @Test(priority = 25)
    public void verifyInprogressData() throws FileNotFoundException {
        test = extent.createTest("Verify InProgress column Data");
       // Pages.WebCommon().verifyWebTableData();
        Pages.WebCommon().verifyDespensingTaskTable();



    }*/

    @Test(priority = 27)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();

    }
    @Test(priority =28)
    public void verifypatientInformations() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify patientInformation");
        Thread.sleep(4000);
        //  Pages.PatientInformations().verifyBasicDetailTable();
        //  Pages.PatientInformations().verifyContactDetail();
        //  Pages.PatientInformations().userDetails();
        //  Pages.OrderDetailsDP().addressDetailsTable();
        //   Pages.OrderDetailsDP().verifyDeliveryDetail();
        Pages.OrderDetailsDP().pendingMedicationTableDp();
        Pages.OrderDetailsDP().orderReadyForDelivery();


    }

    @Test(priority = 29)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);
    }
    @Test(priority = 30)
    public void verifyLogoutFunctionalityDespensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Thread.sleep(2000);
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 31)
    public void verifyOutforDelivery() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        // Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();
        Thread.sleep(4000);
        Pages.Dispatched().OutForDeliveryFunctionality();
        Thread.sleep(3000);


    }
    @Test(priority = 32)
    public void verifyLogoutAfterDispatchedFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }


}
