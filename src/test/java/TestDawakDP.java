import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;
public class TestDawakDP extends BaseClass {

    @Test(priority = 1)
    public void verifyCPLogin() throws InterruptedException {
        test = extent.createTest("Login to DP Portal");
        Pages.LoginDP().DPLogin();
        Pages.Mailinator().verifyDpOtp();
        Pages.LoginDP().verifyEnteringOtp();
       // Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);

//        Pages.ReadyForDelivery().deliveryFunctionality("2401120311");
    }

    @Test(priority = 2)
    public void verifyOrderInTOdo() throws InterruptedException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.HomeDP().verifyHomePageHeader();
        Pages.HomeDP().SearchForOrder();
        Pages.HomeDP().clickonAssign();
    }

    @Test(priority = 3)
    public void verifyOrderInProgress() throws InterruptedException {
        test = extent.createTest("Verify Making Order In InProgressTAB");
        Pages.NavigationsDP().navigateTOInprogressTab();
        Pages.HomeDP().moveToInprogressandVerify();
        Pages.HomeDP().clickonDetailButtonInInprogressTab();
    }

    @Test(priority = 4)
    public void verifyOrderDispensing() throws InterruptedException {
        test = extent.createTest("Verify Making Order In Dispensing TAB");
        Pages.OrderDetailsDP().dispensingOrder();
        Pages.NavigationsDP().navigateTODispensingInProgressTab();
       Pages.HomeDP().searchOrderInDispensingInProgress();
       Pages.HomeDP().clickDetailButtonInDispensingInprogress();
        Pages.OrderDetailsDP().orderReadyForDelivery();

    }

    @Test(priority = 5)
    public void verifyDeliveryFunctionality() throws InterruptedException {
        test = extent.createTest("Verify Making Order In  Ready for Delivery TAB");
       Pages.ReadyForDelivery().deliveryFunctionality(prescriptionOrderID);

    }
    @Test(priority = 5)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }
}