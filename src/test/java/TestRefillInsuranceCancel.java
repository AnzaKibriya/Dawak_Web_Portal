import APICalls.LoginApiCall;
import APICalls.RefillsApiCall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;

public class TestRefillInsuranceCancel extends BaseClass {

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
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 3)

    public void verifyHomePageCalCenter() throws FileNotFoundException, InterruptedException, FileNotFoundException {
        test = extent.createTest("Home page call centre");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().clickOnAssign();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }
    @Test(priority = 4)
    public void verifyMoveToOrderDetailsCallCenter() throws InterruptedException, AWTException, AWTException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.OrderDetailsCallCentre().addAddress();
        Pages.WebCommon().waitForLoaderInvisibility();
    }


    @Test(priority = 5)
    public void verifyLogoutFunctionalityDispensing() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }


    @Test(priority = 6)
    public void verifyCPLogin() throws InterruptedException {
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
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }
    @Test(priority = 9)
    public void verifyInProgressColumnData() throws FileNotFoundException {
        test = extent.createTest("Verify Data present in  In-progress column");
        Pages.Home().verifyDataInWebTable();
        Pages.WebCommon().verifyTaskTable();

    }
    @Test(priority = 10)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    } @Test(priority = 11)
    public void verifyInsuranceApproval() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Insurance Approval functionality");
        Pages.OrderDetails().clickOnSendInsurenceApproval();
        Pages.NavigationsCP().navigateTOInsuranceInprogressTab();
        Pages.OrderDetails().verifySendInsuranceApproval();
        Pages.OrderDetails().approveMedicineInsuranceUsingRefillCopay();
    }
    @Test(priority = 12)
    public void verifyLogoutFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 13)
    public void loginAdminPortal() throws InterruptedException {
        test = extent.createTest("Login to Admin portal");
        Pages.LoginCallCentre().adminLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }
    @Test(priority = 14)
    public void SearchForOrder() throws InterruptedException {
        test = extent.createTest("SearchForOrder");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageAdmin().allOrders();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 15)
    public void orderCancel() throws InterruptedException {
        test = extent.createTest("Cancel Order");
        Pages.OrderDetailsAdmin().cancelOrder();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForLoaderInvisibility();
    }
    @Test(priority = 16)
    public void verifyCancel()
    {
        test = extent.createTest("verify Cancel");
        Pages.OrderDetailsAdmin().verifyCancelstatus();
    }

    @Test(priority = 17)
    public void verifyLogoutFunctionalityAdmin() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 20)
    public void verifyCPLoginCp() throws InterruptedException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLoginAddressChange();
        Pages.LoginCP().verifyEnteringOtp();

    }
    @Test(priority = 21)
    public void verifyTodoColumnData() {
        test = extent.createTest("Verify Data present in Todo  column");
        Pages.Home().verifyTaskName();

    }

    @Test(priority = 22)
    public void verifyOrderInTOdoCen() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().searchTaskTable(prescriptionOrderID);

    }
    @Test(priority = 23)
    public void verifyMakingOrderInProgressCen() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().searchTaskTable(prescriptionOrderID);
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.OrderDetails().refillCancellationTask();

    }
    @Test(priority = 24)
    public void verifyLogoutFunctionalityCen() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 25)
    public void loginAdminPortalAd() throws InterruptedException {
        test = extent.createTest("Login to Admin portal");
        Pages.LoginCallCentre().adminLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }
    @Test(priority = 26)
    public void SearchForOrderAd() throws InterruptedException {
        test = extent.createTest("SearchForOrder");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageAdmin().allOrders();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 27)
    public void verifyCancelAd()
    {
        test = extent.createTest("verify Cancel");
        Pages.OrderDetailsAdmin().verifyCancelstatus();
    }
    @Test(priority = 28)
    public void verifyLogoutFunctionalityAd() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
}
