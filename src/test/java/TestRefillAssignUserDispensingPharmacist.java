import APICalls.*;
import Helper.BaseClass;
import Pages.Pages;
import model.ListAPICall;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestRefillAssignUserDispensingPharmacist extends BaseClass {
    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a refill prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        RefillsAppJourneyApiCall.makeRefillsApiCall(accessToken, prescriptionOrderID);
    }
    @Test(priority = 2)
    public void loginToDawak() throws InterruptedException {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();
    }
    @Test(priority = 3)
    public void addPatient() throws InterruptedException {
        test = extent.createTest("Login to Dawak");
        AddPatientApiCall.AddPatientApiCal();

    }

    @Test(priority = 4)
    public void verifyOTP() throws InterruptedException {
        test = extent.createTest("Login to Dawak");
        VerifyOTPCall.otpCall();

    }

    @Test(priority = 5)
    public void Dashboard()
    {
        test = extent.createTest("Login to Dawak");
        LogoutAPICall.logoutApiCall();

    }

    @Test(priority = 6)
    public void loginToDawakagain() throws InterruptedException {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();
    }


    @Test(priority = 7)
    public void verifyListAPI() throws InterruptedException {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();

    }
    @Test(priority = 8)
    public void deliveryAPI() {
        test = extent.createTest("Verify Delivery API");
        DeliveryRefillAPI.deliveryApiCall();
    }

    @Test(priority = 9)
    public void verifyCPLogin() throws IOException, InterruptedException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLogin();
        Pages.LoginCP().verifyEnteringOtp();
    }
    @Test(priority = 10)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }
    @Test(priority = 11)
    public void verifyTodoColumnData() {
        test = extent.createTest("Verify Data present in Todo  column");
        Pages.Home().verifyDataInWebTable();

    }
    @Test(priority = 12)
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 15)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    }

    @Test(priority = 16)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingRefillCopay();
    }

    @Test(priority = 17)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 18)
    public void verifyLogin() throws InterruptedException {
        test = extent.createTest("Verify LOgin to Dawak Mobile  API");
        BaseClass.getCurrentDateTime();
        DawakLoginAPICall.makeLoginApiCall();
    }

    @Test(priority = 19)
    public void verifyListAPIPayment() throws InterruptedException {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();

    }

    @Test(priority = 20)
    public void verifyDateAPICall() throws InterruptedException {
        test = extent.createTest("Verify selecting Date API");
        SelectingDateAPICall.selectDateApiCall();
    }

    @Test(priority = 21)
    public void verifyDashboardAPI() {
        test = extent.createTest("Verify DashboardPrescription API");
        DashboardPrescriptionAPICall.dashBoardPrescriptionAPICall();
    }

    @Test(priority = 22)
    public void verifyPaymentAPI() {
        test = extent.createTest("Verify Payment API");
        RefillPaymentAPI.paymentAPICAll();
    }
    @Test(priority = 23)
    public void loginCallCenter() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().adminLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }
    @Test(priority = 24)
    public void SearchForOrder() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("SearchForOrder");
        Pages.HomePageAdmin().dispensingOrders();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().searchTaskTable(prescriptionOrderID);
        Pages.HomePageAdmin().assignButtonDispensing();
        Pages.HomePageAdmin().selectingPharmacistDispensing();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 25)
    public void verifyLogoutFunctionalityCallCentre() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }


    @Test(priority = 26)
    public void verifyDPLogin() {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.LoginDP().verifyEnteringOtp();

    }

    @Test(priority = 27)
    public void verifyOrderInTOdoDispensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();

    }

    @Test(priority = 28)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }



    @Test(priority = 29)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();
    }

    @Test(priority = 30)
    public void verifyPatientInformationDispensingOrderTab() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify Patient Information Dispensing Order Tab");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.OrderDetailsDP().orderReadyForDelivery();
    }

    @Test(priority = 31)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);
    }
    @Test(priority = 32)
    public void verifyLogoutFunctionalityDispensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 33)
    public void verifyOrderOutForDelivery() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.LoginDP().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Dispatched().OutForDeliveryFunctionality();
        Pages.WebCommon().waitForLoaderInvisibility();
    }
    @Test(priority = 34)
    public void verifyLogoutAfterDispatchedFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }




}
