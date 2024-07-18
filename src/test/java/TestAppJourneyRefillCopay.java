import APICalls.*;
import Helper.BaseClass;
import model.ListAPICall;
import org.testng.annotations.Test;

public class TestAppJourneyRefillCopay extends BaseClass {

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













}
