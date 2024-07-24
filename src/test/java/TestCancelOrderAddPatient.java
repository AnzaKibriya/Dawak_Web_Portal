import APICalls.LoginApiCall;
import APICalls.NewPatientApiCall;
import APICalls.PrescriptionApiCall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

public class TestCancelOrderAddPatient extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription Add patient");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
    }

    @Test(priority = 2)
    public void loginAdminPortal() throws InterruptedException {
        test = extent.createTest("Login Admin Portal");
        Pages.LoginCallCentre().adminLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
    }

    @Test(priority = 3)
    public void SearchForOrder() throws InterruptedException {
        test = extent.createTest("SearchForOrder");
        Pages.HomePageAdmin().allOrders();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 4)
    public void orderCancel() throws InterruptedException {
        test = extent.createTest("Cancel Order");
        Pages.OrderDetailsAdmin().cancelOrder();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageAdmin().searchUsingFilters();
        Pages.HomePageAdmin().moveToDetailedPage();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 5)
    public void verifyCancel() {
        test = extent.createTest("Verify Cancel Order");
        Pages.OrderDetailsAdmin().verifyCancelstatus();
    }

    @Test(priority = 6)
    public void verifyLogoutFunctionalityAdmin() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
}
