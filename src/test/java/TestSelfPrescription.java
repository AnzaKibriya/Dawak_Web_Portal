import APICalls.*;
import Helper.BaseClass;
import Pages.Pages;
import model.ListAPICall;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestSelfPrescription extends BaseClass {

    @Test(priority = 1)
    public void creatingExternalPrescription() throws InterruptedException {
        test = extent.createTest("Creating External Prescription : Happy Scenario" );
        DawakLoginAPICall.makeLoginApiCall();
        Pages.WebCommon().waitForAPIResponse();
        String prescriptionFile= UploadFileAPICall.makeUploadFileAPICall();
        prescriptionOrderID = SelfPayAPICall.makeExternalPrescriptionAPICall(prescriptionFile);
        System.out.println(prescriptionOrderID);
    }
    @Test(priority = 2)
    public void verifyCPLogin() throws IOException, InterruptedException {
        test = extent.createTest("Login to Central Pharmacist");
        Pages.LoginCP().CPLogin();
        Pages.LoginCP().verifyEnteringOtp();

    }
    @Test(priority = 3)
    public void verifyOrderInTOdo() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In TODO");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.Home().SearchForOrder(prescriptionOrderID);
    }


    @Test(priority = 5)
    public void verifyMakingOrderInProgress() throws InterruptedException, FileNotFoundException {
        test = extent.createTest("Verify Making Order In Progress State");
        Pages.Home().clickOnAssign();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.Home().moveOrderToInProgressStateAndVerify();
    }


    @Test(priority = 8)
    public void verifyMoveToOrderDetails() throws InterruptedException {
        test = extent.createTest("Verify Navigation to order details page ");
        Pages.NavigationsCP().openOrderDetailPage();

    }
    @Test(priority = 9)
    public void verifyResubmission()
    {
        test = extent.createTest("Verify order Re submission ");
        Pages.ExternalPrescription().selfPayPrescription();

    }

    @Test(priority = 10)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.Logout().verifyLogout();
    }

    /*@Test(priority = 11)
    public void creatingEditExternalPrescription() throws InterruptedException {
        test = extent.createTest("Creating External Prescription : Happy Scenario" );
        DawakLoginAPICall.makeLoginApiCall();
        Pages.WebCommon().waitForAPIResponse();
        String prescriptionFile= UploadFileAPICall.makeUploadFileAPICall();
        prescriptionOrderID = ExternalPrescriptionAPICall.makeExternalPrescriptionAPICall("", "",prescriptionFile);
        ListAPICall.makeListApiCall();
        String cardFront= UploadFileAPICall.makeUploadFileAPICall();
        String cardBack= UploadFileAPICall.makeUploadFileAPICall();
        EditExternalPrescriptionAPICall.makeEditExternalPrescriptionAPICall(cardFront, cardBack, prescriptionFile);
    }*/



}
