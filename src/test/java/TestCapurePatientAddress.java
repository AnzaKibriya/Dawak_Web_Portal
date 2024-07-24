import APICalls.LoginApiCall;
import APICalls.NonAppHomeDeliveryAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCapurePatientAddress  extends BaseClass {
    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        NonAppHomeDeliveryAPICall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        Pages.WebCommon().waitForAPIResponse();
    }

    @Test(priority = 2)
    public void loginCallCenter() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }

    @Test(priority = 3)
    public void verifyHomePageCalCenter() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Home page call centre");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 4)
    public void verifyMoveToOrderDetailsCallCenter() throws InterruptedException, AWTException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        //  Pages.OrderDetailsCallCentre().addAddress();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 5)
    public void verifyResponse() throws InterruptedException, AWTException {
        test = extent.createTest("verify response after clicking did not respond");
        Pages.OrderDetailsCallCentre().response();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageCallCentre().refresh();
    }

    @Test(priority = 7)
    public void VerifyOrderDataSecondTime() throws InterruptedException {
        test = extent.createTest("Verify Data in TODO Page");
        Pages.HomePageCallCentre().clickonDetails();

    }

    @Test(priority = 8)
    public void moveToInProgressTabSecondTime() {

        test = extent.createTest("Move To InProgress Tab");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 6)
    public void moveToToDoTab() throws FileNotFoundException, InterruptedException, AWTException {
        test = extent.createTest("Move to To Do Tab");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.NavigationsCP().navigateTOTodoTab();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.HomePageCallCentre().refresh();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 9)
    public void OpenOrderDetailssecondTime() throws InterruptedException, AWTException, FileNotFoundException {
        Pages.WebCommon().waitForElementsInteractions();
        test = extent.createTest("Open Order Details");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.HomePageCallCentre().openOrderDetails();
        Pages.OrderDetailsCallCentre().response();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageCallCentre().refresh();
    }
    @Test(priority = 10)
    public void moveToToDoTabSecondTime() throws FileNotFoundException, InterruptedException, AWTException {
        test = extent.createTest("Move to To Do Tab");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.NavigationsCP().navigateTOTodoTab();
        Pages.HomePageCallCentre().refresh();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.HomePageCallCentre().verifyNoRecordfoundText();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 14)
    public void verifyMoveToOrderDetailsCallCenterportal() throws InterruptedException, AWTException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.OrderDetailsFrontLine().addAddress();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 11)
    public void verifyLogoutFunctionalitycc() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }


    @Test(priority = 12)
    public void LoginFrontLine() throws InterruptedException {
        test = extent.createTest("Login Front Line Pharmacist");
        Pages.LoginFrontLine().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 13)
    public void verifySearch() throws InterruptedException {
        test = extent.createTest("search for the order");
        Pages.HomepageFrontLine().searchrecord();
    }
    @Test(priority = 15)
    public void verifyLogoutCallCenterFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 16)
    public void CPLogin() throws IOException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLoginAddressChange();
        Pages.LoginCP().verifyEnteringOtp();

    }

    @Test(priority = 17)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }

    @Test(priority = 18)
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.NavigationsCP().moveToNewPrescription();
        Pages.Home().clearSearch();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 19)
    public void verifyInProgressColumnData() {
        test = extent.createTest("Verify Data present in  In-progress column CP Portal");
        Pages.Home().verifyDataInWebTable();
    }

    @Test(priority = 20)
    public void verifyUnAssignFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify un-assign functionality");
        Pages.Home().verifyReAssign();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 21)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.WebCommon().waitForElementsInteractions();

    }

    @Test(priority = 23)
    public void verifyOrderDetails() {
        test = extent.createTest("Verify order details data and Header text ");
        Pages.OrderDetails().verifyDeliveryDetailTable();
        Pages.OrderDetails().verifyOrderDetailTable();
        Pages.OrderDetails().verifyOrderDetailsHeader();
        Pages.OrderDetails().verifyTrackDetailTable();
        Pages.OrderDetails().verifyRemoveFunctionality();
    }

    @Test(priority = 24)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingCopay();
    }

    @Test(priority = 25)
    public void verifyLogoutFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality CP Portal");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 26)
    public void LoginCallCentre() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
    }


    @Test(priority = 27)
    public void homePageCallCentre() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify Home page call centre And Move Order to Inprogres");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 28)
    public void moveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Move to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
    }


    @Test(priority = 29)
    public void completeOrder() throws InterruptedException, AWTException {
        test = extent.createTest("complete order ");
        Pages.OrderDetailsCallCentre().payment();
        Pages.WebCommon().waitForLoaderInvisibility();
    }




    @Test(priority = 31)
    public void verifyLogoutCallCentreFunctionality() throws InterruptedException {
        test = extent.createTest("Verify Logout Call Centre Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 32)
    public void verifyDPLogin() {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLoginAddressChange();
        Pages.LoginDP().verifyEnteringOtp();

    }

    @Test(priority = 33)
    public void verifyOrderInTOdoDispensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
        Pages.HomeDP().clickonAssign();
    }

    @Test(priority = 34)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }
    @Test(priority = 36)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();
    }

    @Test(priority = 37)
    public void verifyPatientInformationDispensingOrderTab() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify Patient Information Dispensing Order Tab");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.OrderDetailsDP().orderReadyForDelivery();
    }

    @Test(priority = 38)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);
    }

    @Test(priority = 39)
    public void verifyLogoutFunctionalityDispensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();

    }

    @Test(priority = 40)
    public void verifyOrderOutForDelivery() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.LoginDP().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Dispatched().OutForDeliveryFunctionality();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 41)
    public void verifyLogoutAfterDispatchedFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();

    }



}
