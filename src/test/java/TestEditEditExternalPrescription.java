import APICalls.DawakLoginAPICall;
import APICalls.EditExternalPrescriptionAPICall;
import APICalls.ExternalPrescriptionAPICall;
import APICalls.UploadFileAPICall;
import Helper.BaseClass;
import Pages.Pages;
import model.ListAPICall;
import org.testng.annotations.Test;

public class TestEditEditExternalPrescription extends BaseClass {
    @Test(priority = 1)
    public void creatingExternalPrescription() throws InterruptedException {
        test = extent.createTest("Creating External Prescription : Happy Scenario" );
        DawakLoginAPICall.makeLoginApiCall();
        Pages.WebCommon().waitForAPIResponse();
        String prescriptionFile= UploadFileAPICall.makeUploadFileAPICall();
        prescriptionOrderID = ExternalPrescriptionAPICall.makeExternalPrescriptionAPICall("", "",prescriptionFile);
        ListAPICall.makeListApiCall();
        String cardFront= UploadFileAPICall.makeUploadFileAPICall();
        String cardBack= UploadFileAPICall.makeUploadFileAPICall();
        EditExternalPrescriptionAPICall.makeEditExternalPrescriptionAPICall(cardFront, cardBack, prescriptionFile);
    }
}
