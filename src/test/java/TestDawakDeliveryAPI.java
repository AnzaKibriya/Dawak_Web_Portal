import APICalls.DawakLoginAPICall;
import APICalls.DeliveryAPICall;
import APICalls.LoginApiCall;
import APICalls.PrescriptionApiCall;
import Helper.BaseClass;
import model.*;
import org.testng.annotations.Test;

public class TestDawakDeliveryAPI extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() throws InterruptedException {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        //  NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
        PrescriptionApiCall.makePrescriptionApiCall(accessToken, prescriptionOrderID);
        Thread.sleep(8000);
    }


    @Test(priority = 2)
    public  void loginTODawak()
    {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();

    }

    @Test(priority = 3)
    public void verifyListAPI() throws InterruptedException {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();
        Thread.sleep(12000);

    }

    @Test(priority = 4)
    public void deliveryAPI()
    {
        test = extent.createTest("Verify Delivery API");
        DeliveryAPICall.deliveryApiCall();
        // Del.verifyDelivery();


    }

}
