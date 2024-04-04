import Helper.BaseClass;
import model.CreateOtpApiCall;
import model.LoginDpApiCall;
import model.PutOTPApiCall;
import org.testng.annotations.Test;

public class TestDawakDPAPI extends BaseClass {

    @Test(priority = 1)
    public void verifyDPLogin() {
        test = extent.createTest("Login to DP Portal");
        LoginDpApiCall.makeLoginApiCall();
        CreateOtpApiCall.createOtpApiCall();
        PutOTPApiCall.OTPApiCall();


    }

    }
