import APICalls.*;
import Helper.BaseClass;
import Pages.Pages;
import model.ListAPICall;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCancelOrderNewPrescription extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
      //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        PrescriptionApiCall.makePrescriptionApiCall(accessToken, prescriptionOrderID);
    }
    @Test(priority = 2)
    public void loginToDawak() throws InterruptedException {
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
    public void verifyCPLogin() throws IOException, InterruptedException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLogin();
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
        Pages.NavigationsCP().moveToNewPrescription();
        Pages.Home().clearSearch();
        Pages.Home().SearchForOrder(prescriptionOrderID);
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }

    @Test(priority = 12)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

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
    public void loginAdminPortal() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.LoginCallCentre().adminLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 18)
    public void SearchForOrder() throws InterruptedException {
        test = extent.createTest("SearchForOrder");
        Pages.HomePageAdmin().allOrders();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 19)
    public void orderCancel() throws InterruptedException {
        test = extent.createTest("Cancel Order");
        Pages.OrderDetailsAdmin().cancelOrder();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.WebCommon().waitForElementsInteractions();

    }
    @Test(priority = 20)
    public void verifyLogoutFunctionalityAdmin() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 21)
    public void verifyCPLoginSecondTime() throws IOException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLogin();
        Pages.LoginCP().verifyEnteringOtp();

    }

    @Test(priority = 22)
    public void verifyOrderInTOdoSecondTime() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().searchTaskTable(prescriptionOrderID);
        Pages.Home().verifyTaskName();
    }

    @Test(priority = 23)
    public void verifyLogoutFunctionalityCp() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 24)
    public void loginAdminPortalSecondTime() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().adminLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }
    @Test(priority = 25)
    public void SearchForOrderSecondTime() throws InterruptedException {
        test = extent.createTest("SearchForOrder");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageAdmin().allOrders();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 26)
    public void verifyCancel()
    {
        Pages.OrderDetailsAdmin().verifyCancelstatus();
    }

    @Test(priority = 27)
    public void verifyLogoutFunctionalityAdminPortal() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

}
