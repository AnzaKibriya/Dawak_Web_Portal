import Helper.BaseClass;
import Pages.Pages;
import model.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCancelOrder extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        PrescriptionApiCall.makePrescriptionApiCall(accessToken, prescriptionOrderID);
        Thread.sleep(8000);
    }


    @Test(priority = 2)
    public  void loginTODawak()
    {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();

    }

    @Test(priority = 3)
    public void verifyListAPI() throws InterruptedException {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();
        Thread.sleep(12000);

    }

    @Test(priority = 4)
    public void deliveryAPI()
    {
        test = extent.createTest("Verify Delivery API");
        DeliveryAPICall.deliveryApiCall();
        // Del.verifyDelivery();


    }





    @Test(priority = 5)
    public void verifyCPLogin() throws IOException, InterruptedException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().invalidCPLogin();
        Pages.LoginCP().CPLogin();
//        Pages.Mailinator().verifyOtp();
        Pages.LoginCP().verifyEnteringOtp();

    }


    @Test(priority = 6)
    public void verifyFilterValidation() throws InterruptedException, FileNotFoundException {

        test = extent.createTest("Verify Filter Validation");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().verifyFilters();


    }

    @Test(priority = 7)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }

    @Test(priority = 8)
    public void verifyTodoColumnData() throws FileNotFoundException {
        test = extent.createTest("Verify Data present in Todo  column");
        Pages.Home().verifyDataInWebTable();

    }

    @Test(priority = 9)
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.NavigationsCP().moveToNewPrescription();
        Pages.Home().clearSearch();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 10)
    public void verifyInProgressColumnData() throws FileNotFoundException {
        test = extent.createTest("Verify Data present in  In-progress column");
        Pages.Home().verifyDataInWebTable();
        Pages.WebCommon().verifyTaskTable();

    }

    @Test(priority = 11)
    public void verifyUnAssignFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify un-assign functionality");
        Pages.Home().verifyReAssign();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority =12)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    }
    @Test(priority = 13)
    public void verifyPatientInformation() throws FileNotFoundException {
        test = extent.createTest("Verify patient information in orderDetails page ");
        Pages.PatientInformations().verifyBasicDetailTable();
        Pages.PatientInformations().verifyContactDetail();
        Pages.PatientInformations().userDetails();
        Pages.PatientInformations().pendingMedicationTable();
    }
    @Test(priority = 14)
    public void verifyOrderDetails() throws FileNotFoundException {
        test = extent.createTest("Verify order details data and Header text ");
        Pages.OrderDetails().verifyDeliveryDetailTable();
        Pages.OrderDetails().verifyOrderDetailTable();
        Pages.OrderDetails().verifyOrderDetailsHeader();
        Pages.OrderDetails().verifyTrackDetailTable();
//        Pages.OrderDetails().verifyViewDetailsInformation();
        Pages.OrderDetails().verifyRemoveFunctionality();
    }

    @Test(priority = 15)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingCopay();
    }

    @Test(priority = 16)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }


    @Test(priority = 17)
    public void verifyLogin() throws InterruptedException {
        test = extent.createTest("Verify Delivery API");
           Thread.sleep(19000);
        BaseClass.getCurrentDateTime();
        DawakLoginAPICall.makeLoginApiCall();
        Thread.sleep(12000);
    }

    @Test(priority = 18)
    public void verifyListAPIPayment() throws InterruptedException {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();
        Thread.sleep(5000);

    }
    @Test(priority = 19)
    public void verifyCancelOrder()
    {
        test = extent.createTest("Verify cancel order API");
        OrdercalcelAPICall.ordercancelAPI();

    }


}
