import APICalls.CallMeBackAPICall;
import APICalls.DawakLoginAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;

public class TestCallMeBackHappyFlow extends BaseClass {

    @Test(priority = 1)
    public void loginTODawakMobileApi() throws InterruptedException {
        test = extent.createTest("Login to Dawak");
        DawakLoginAPICall.makeLoginApiCall();
        Pages.WebCommon().waitForAPIResponse();

    }

    @Test(priority = 2)
    public void CallMeBack() {

        test = extent.createTest("Hit Call Me Back API");
        CallMeBackAPICall.makeCallMeBackAPICall(accessTokens);

    }

    @Test(priority = 3)
    public void loginCallCenter() throws InterruptedException {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
    }

    @Test(priority = 4)
    public void VerifyOrderData() throws FileNotFoundException {
        test = extent.createTest("Verify Data in TODO Page");
        Pages.HomePageCallCentre().searchForRecord();
        Pages.HomePageCallCentre().verifyTaskTable();
        Pages.HomePageCallCentre().clickonDetails();

    }

    @Test(priority = 5)
    public void moveToInProgressTab() {

        test = extent.createTest("Move To InProgress Tab");
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 6)
    public void OpenOrderDetailsAndCompleteTask() throws InterruptedException, AWTException, FileNotFoundException {
        test = extent.createTest("Open Order Details and complete Task");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageCallCentre().searchForRecord();
        Pages.HomePageCallCentre().verifyTaskTable();
        Pages.HomePageCallCentre().openOrderDetails();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.OrderDetailsCallCentre().verifyCallCentreUserDetailTable();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.OrderDetailsCallCentre().taskCompleted();
    }

    @Test(priority = 7)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.Logout().verifyLogout();
    }

}
