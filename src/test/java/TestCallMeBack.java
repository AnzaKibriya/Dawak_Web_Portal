import APICalls.CallMeBackAPICall;
import APICalls.DawakLoginAPICall;
import Helper.BaseClass;
import Pages.Pages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;

public class TestCallMeBack extends BaseClass {

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
    public void loginCallCenter() {
        test = extent.createTest("Login Call Centre");
        Pages.LoginCallCentre().CCLogin();
        Pages.LoginCallCentre().verifyEnteringOtp();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 4)
    public void VerifyOrderData() throws FileNotFoundException, InterruptedException {
        test = extent.createTest("Verify Data in TODO Page");
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageCallCentre().searchForRecord();
        Pages.HomePageCallCentre().verifyTaskTable();
        Pages.HomePageCallCentre().clickonDetails();

    }

    @Test(priority = 5)
    public void moveToInProgressTab() throws FileNotFoundException, InterruptedException {

        test = extent.createTest("Move To InProgress Tab");
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.HomePageCallCentre().searchForRecord();
        Pages.HomePageCallCentre().verifyTaskTable();
    }

    @Test(priority = 6)
    public void OpenOrderDetails() throws InterruptedException, AWTException, FileNotFoundException {
        test = extent.createTest("Open Order Details");
        Pages.HomePageCallCentre().openOrderDetails();
       // Pages.OrderDetailsCallCentre().verifyCallCentreUserDetailTable();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.OrderDetailsCallCentre().response();
    }


    @Test(priority = 7)
    public void moveToInProgressTabSecondTime() throws InterruptedException, AWTException {
        test = extent.createTest("Move To InProgress Tab");
        Pages.HomePageCallCentre().refresh();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.NavigationsCP().navigateTOTodoTab();
        Pages.HomePageCallCentre().refresh();
        Pages.WebCommon().waitForLoaderInvisibility();
    }


    @Test(priority = 9)
    public void moveToToDoTab() {
        test = extent.createTest("Move to To Do Tab");
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.NavigationsCP().navigateTOInprogressTab();
        Pages.WebCommon().waitForLoaderInvisibility();


    }

    @Test(priority = 10)
    public void OpenOrderDetailssecondTime() throws InterruptedException, AWTException {
        test = extent.createTest("Open Order Details");
        Pages.HomePageCallCentre().searchForRecord();
        Pages.HomePageCallCentre().openOrderDetails();
        Pages.WebCommon().waitForElementsInteractions();
        Pages.OrderDetailsCallCentre().response();
        Pages.WebCommon().waitForLoaderInvisibility();

    }

    @Test(priority = 8)
    public void VerifyOrderDataSecondTime() {
        test = extent.createTest("Verify Data in TODO Page");
        Pages.HomePageCallCentre().searchForRecord();
        Pages.HomePageCallCentre().clickonDetails();
        Pages.WebCommon().waitForLoaderInvisibility();
    }

    @Test(priority = 11)
    public void verifyCallBackRecordNotPresent() throws InterruptedException, AWTException {
        Pages.HomePageCallCentre().verifyNoRecordfoundText();
        test = extent.createTest("verify Call Back RecordNotPresent");
        Pages.NavigationsCP().navigateTOTodoTab();
        Pages.HomePageCallCentre().refresh();
        Pages.WebCommon().waitForLoaderInvisibility();
        Pages.HomePageCallCentre().searchForRecord();
    }


    @Test(priority = 12)
    public void verifyLogoutFunctionality() {
        Pages.Logout().verifyLogout();
        test = extent.createTest("Logout Functionality");
        Pages.WebCommon().waitForLoaderInvisibility();
    }
}



