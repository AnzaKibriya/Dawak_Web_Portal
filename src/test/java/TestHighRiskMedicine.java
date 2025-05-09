import APICalls.DawakLoginAPICall;
import APICalls.DeliveryAPICall;
import APICalls.LoginApiCall;
import APICalls.PrescriptionApiCall;
import Helper.BaseClass;
import Pages.Pages;
import model.ListAPICall;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestHighRiskMedicine extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        // NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        PrescriptionApiCall.makePrescriptionApiCall(accessToken, prescriptionOrderID);
        Pages.WebCommon().waitForAPIResponse();
    }

    @Test(priority = 2)
    public void loginTODawak() throws InterruptedException {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();

    }
    @Test(priority = 3)
    public void verifyListAPI() throws InterruptedException {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();


    }
    @Test(priority = 4)
    public void deliveryAPI() {
        test = extent.createTest("Verify Delivery API");
        DeliveryAPICall.deliveryApiCall();
    }

    @Test(priority = 5)
    public void verifyCPLogin() throws IOException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLogin();
        Pages.LoginCP().verifyEnteringOtp();

    }

    @Test(priority = 6)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }

    @Test(priority = 7)
    public void verifyhighincp(){
        test = extent.createTest("Verify Hig risk medicine order");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Home().highlight();
        Pages.WebCommon().waitForLoaderInvisibility();

    }
    @Test(priority = 8)
    public void verifyMakingOrderInProgresstab() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.NavigationsCP().moveToNewPrescription();
        Pages.Home().clearSearch();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }
    @Test(priority = 9)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    }
    @Test(priority = 10)
    public void risk(){
        test = extent.createTest("Verify Hig risk medicine order");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Home().highlight();
        Pages.WebCommon().waitForLoaderInvisibility();

    }
    @Test(priority = 11)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingNopay();
    }

    @Test(priority = 12)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }


    @Test(priority = 13)
    public void verifyDPLogin() {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.LoginDP().verifyEnteringOtp();

    }

    @Test(priority = 14)
    public void verifyOrderInTOdoDispensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
        Pages.HomeDP().clickonAssign();
    }
    @Test(priority = 15)
    public void verifyhighinTOdo(){
        test = extent.createTest("Verify Hig risk medicine order");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Home().highlight();
        Pages.WebCommon().waitForLoaderInvisibility();

    }

    @Test(priority = 16)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }
    @Test(priority = 17)
    public void verifyhighinProgress(){
        test = extent.createTest("Verify Hig risk medicine order");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Home().highlight();
        Pages.WebCommon().waitForLoaderInvisibility();

    }


    @Test(priority = 18)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();

    }

    @Test(priority = 19)
    public void verifyPatientInformationDispensingTab() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify patientInformation");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.OrderDetailsDP().orderReadyForDelivery();
    }

    @Test(priority = 20)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);
    }

    @Test(priority = 21)
    public void verifyLogoutFunctionalityDespensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
    }







}
