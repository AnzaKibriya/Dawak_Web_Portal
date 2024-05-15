import Helper.BaseClass;
import APICalls.CreateOtpApiCall;
import APICalls.LoginDpApiCall;
import APICalls.PutOTPApiCall;
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
