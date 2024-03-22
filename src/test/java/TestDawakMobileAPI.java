import Helper.BaseClass;
import model.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestDawakMobileAPI extends BaseClass {

    @Test(priority = 1)
    public void createANewPrescription() {
        test = extent.createTest("create a new prescription");
        accessToken = LoginApiCall.makeLoginApiCall();
        prescriptionOrderID = generateRandomNumericString();
        System.out.println(prescriptionOrderID);
        NewPatientApiCall.makeCreatePatientApiCall(accessToken, prescriptionOrderID);
    }


    @Test(priority = 2)
    public  void loginTODawak()
    {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();

    }

    @Test(priority = 3)
    public void verifyListAPI()
    {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();

    }

}
