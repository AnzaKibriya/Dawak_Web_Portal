import APICalls.LoginApiCall;
import APICalls.NonAppHomeDeliveryAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestCallCentreAdmin  extends BaseClass {

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
    public void loginCallCenterAdmin() throws InterruptedException {
        test = extent.createTest("Login Call Centre Admin");
        Pages.LoginCallCentre().LoginCallCentreAdmin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }

    @Test(priority = 3)
    public void verifyHomePageCalCenter() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Home page call centre");
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().clickOnAssign();
        Pages.HomePageAdmin().selectingPharmaCistCallCentre();
    }

    @Test(priority = 4)
    public void verifyLogoutCallCenterFunctionality() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 5)
    public void loginCallCenter() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }
    @Test(priority = 6)
    public void verifyHomePageCalCenterAdmin() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Home page call centre");
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.HomePageCallCentre().verifyTaskTable();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 7)
    public void verifyLogoutCallCenter() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 8)
    public void loginCallCenterAdminPortal() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForAPIResponse();
    }
    @Test(priority = 9)
    public void verifyHomePageCalCenterAdminPortal() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Home page call centre");
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.HomePageCallCentre().SearchForOrder(prescriptionOrderID);
        Pages.HomePageCallCentre().verifyTaskTable();
        Pages.HomePageCallCentre().unassign();
        Pages.WebCommon().waitForElementsInteractions();
    }
    @Test(priority = 10)
    public void verifyLogout() throws InterruptedException {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
        Pages.WebCommon().waitForElementsInteractions();
    }


}
