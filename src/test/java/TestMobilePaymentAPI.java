import APICalls.DashboardPrescriptionAPICall;
import APICalls.DawakLoginAPICall;
import APICalls.PaymentAPICall;
import APICalls.SelectingDateAPICall;
import Helper.BaseClass;
import model.*;
import org.testng.annotations.Test;
public class TestMobilePaymentAPI extends BaseClass {

    @Test(priority = 1)
    public void verifyLogin() throws InterruptedException {
        test = extent.createTest("Verify LOgin to Dawak Mobile  API");
        BaseClass.getCurrentDateTime();
        DawakLoginAPICall.makeLoginApiCall();
        Thread.sleep(12000);
    }

    @Test(priority = 2)
    public void verifyListAPIPayment()
    {
        test = extent.createTest("Verify List API");
        ListAPICall.makeListApiCall();

    }

    @Test(priority = 3)
    public void verifyDateAPICall()
    {
        test = extent.createTest("Verify selecting Date API");
        SelectingDateAPICall.selectDateApiCall();


    }
    @Test(priority = 4)
    public void verifyDashboardAPI()
    {
        test = extent.createTest("Verify DashboardPrescription API");
        DashboardPrescriptionAPICall.dashBoardPrescriptionAPICall();

    }

    @Test(priority = 5)
    public void verifyPaymentAPI()
    {
        test = extent.createTest("Verify Payment API");
        PaymentAPICall.paymentAPICAll();

    }


}
