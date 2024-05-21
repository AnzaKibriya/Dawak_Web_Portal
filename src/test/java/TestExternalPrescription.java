import APICalls.DawakLoginAPICall;
import APICalls.ExternalPrescriptionAPICall;
import APICalls.UploadFileAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

public class TestExternalPrescription extends BaseClass {
    @Test(priority = 1)
    public void creatingExternalPrescription() throws InterruptedException {
        test = extent.createTest("Creating External Prescription : Happy Scenario" );
        DawakLoginAPICall.makeLoginApiCall();
        Pages.WebCommon().waitForAPIResponse();
        String cardFront= UploadFileAPICall.makeUploadFileAPICall();
        String cardBack= UploadFileAPICall.makeUploadFileAPICall();
        String prescriptionFile= UploadFileAPICall.makeUploadFileAPICall();
        prescriptionOrderID = ExternalPrescriptionAPICall.makeExternalPrescriptionAPICall(cardFront, cardBack,prescriptionFile);
    }
}
