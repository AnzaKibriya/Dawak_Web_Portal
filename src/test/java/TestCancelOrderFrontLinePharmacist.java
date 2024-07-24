import APICalls.LoginApiCall;
import APICalls.NonAppFrontLineDeliveryAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;

public class TestCancelOrderFrontLinePharmacist  extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        NonAppFrontLineDeliveryAPICall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
    }

    @Test(priority = 2)
    public void LoginFrontLine() throws InterruptedException {
        test = extent.createTest("Login Front Line Pharmacist");
        Pages.LoginFrontLine().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 3)
    public void verifySearch() throws InterruptedException {
        test = extent.createTest("search for the order");
        Pages.HomepageFrontLine().searchrecord();
    }

    @Test(priority = 4)
    public void verifyMoveToOrderDetailsCallCenter() throws InterruptedException, AWTException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();
        Pages.OrderDetailsFrontLine().addAddress();
    }

}
