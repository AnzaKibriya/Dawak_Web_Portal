import APICalls.LoginApiCall;
import APICalls.RefillsApiCall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestRefillNonAppJourney extends BaseClass {
    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a refill prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        RefillsApiCall.makeRefillsApiCall(accessToken, prescriptionOrderID);
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
        Pages.HomePageCallCentre().verifyTaskTable();
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 4)
    public void verifyMoveToOrderDetailsCallCenter() throws InterruptedException, AWTException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.OrderDetailsCallCentre().addAddress();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 5)
    public void verifyLogoutCallCenterFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 6)
    public void verifyCPLogin() throws IOException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLoginAddressChange();
        Pages.LoginCP().verifyEnteringOtp();

    }

    @Test(priority = 7)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }

    @Test(priority = 8)
    public void verifyTodoColumnData() {
        test = extent.createTest("Verify Data present in Todo  column");
        Pages.Home().verifyDataInWebTable();

    }

    @Test(priority = 9)
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
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

    @Test(priority = 12)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    }

    @Test(priority = 13)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingRefillCopay();
    }

    @Test(priority = 14)
    public void verifyLogoutFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 15)
    public void LoginCallCentre() throws InterruptedException {
        test = extent.createTest("Login Call Center");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
    }
    @Test(priority = 16)
    public void verifyHomePageCallCentre() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Home page call centre");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 17)
    public void moveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Move to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
    }


    @Test(priority = 18)
    public void completOorder() throws InterruptedException, AWTException {
        test = extent.createTest("complete order ");
        Pages.OrderDetailsCallCentre().payment();
        Pages.WebCommon().waitForLoaderInvisibility();
    }


    @Test(priority = 19)
    public void verifyLogoutCallCentreFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 20)
    public void verifyDPLogin() {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLoginAddressChange();
        Pages.LoginDP().verifyEnteringOtp();

    }

    @Test(priority = 21)
    public void verifyOrderInTOdoDispensing() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
        Pages.HomeDP().clickonAssign();
    }

    @Test(priority = 22)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
        Pages.WebCommon().waitForElementsInteractions();

    }
    @Test(priority = 24)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
        Pages.HomeDP().searchOrderInDispensingInProgress();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomeDP().clickDetailButtonInDispensingInprogress();

    }

    @Test(priority = 25)
    public void verifyPatientInformationDispensingTab() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify Patient Information Dispensing Tab");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.OrderDetailsDP().orderReadyForDelivery();


    }

    @Test(priority = 26)
    public void verifyDeliveryFunctionality() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
        Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);
    }

    @Test(priority = 27)
    public void verifyLogoutFunctionalityDispensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
    }

    @Test(priority = 28)
    public void verifyOutForDelivery() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Login to DP Portal and Verify Order Out For Delivery");
        Pages.LoginDP().DPLogin();
        Pages.LoginDP().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Dispatched().OutForDeliveryFunctionality();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 29)
    public void verifyLogoutAfterDispatchedFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

}
