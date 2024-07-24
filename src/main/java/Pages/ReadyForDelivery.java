package Pages;

import APICalls.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.io.FileNotFoundException;

import static Helper.BaseClass.webJavascriptExecutor;

public class ReadyForDelivery {
    WebDriver driver;
    @FindBy(xpath = "//span[text()=' Ready for Delivery ']")
    WebElement readyDelivery;

    @FindBy(xpath = "//button[text()=' Yes']")
    WebElement yes;

    @FindBy(xpath = "//button[@aria-label='Yes']")
    WebElement yesButton;
    @FindBy(xpath = "//i[@mattooltip='Detail']")
    WebElement details;

    public ReadyForDelivery(WebDriver Driver) {
        driver = Driver;
    }

    public void deliveryFunctionality(String ID) throws InterruptedException, FileNotFoundException {
        webJavascriptExecutor().executeScript("arguments[0].click();", readyDelivery);
        Pages.WebCommon().waitForLoaderInvisibility();//waiting for loader
        Pages.HomeDP().SearchForOrder();// searching for sepecific order
        Pages.WebCommon().waitForLoaderInvisibility(); //waiting for loader
        details.click();//clicking on detailed button
        String getUrl = driver.getCurrentUrl();//getting current url
        String[] tokens = getUrl.split("/");//
        System.out.println(tokens[tokens.length-3]);
        GetShipaIdApiCall.setDeliveryID(tokens[tokens.length-3]); //getting shipa id from url
        Thread.sleep(4000);
        LoginDpApiCall.makeLoginApiCall();
        Thread.sleep(2000);
        CreateOtpApiCall.createOtpApiCall();
        Thread.sleep(2000);
        String dpAccessToken = PutOTPApiCall.OTPApiCall();
        String shipaOrderNum = GetShipaIdApiCall.makeShipaIdApiCall(dpAccessToken);
        ShipaInitiateEventApiCall.makeShipaInitiateEventApiCall(dpAccessToken, shipaOrderNum, "initiated");
        ShipaInitiateEventApiCall.makeShipaInitiateEventApiCall(dpAccessToken, shipaOrderNum, "completed");
    }



    public void deliveryFunctionalityFailed(String ID) throws InterruptedException, FileNotFoundException {
        webJavascriptExecutor().executeScript("arguments[0].click();", readyDelivery);
        Pages.WebCommon().waitForLoaderInvisibility();//waiting for loader
        Pages.HomeDP().SearchForOrder();// searching for sepecific order
        Pages.WebCommon().waitForLoaderInvisibility(); //waiting for loader
        details.click();//clicking on detailed button
        String getUrl = driver.getCurrentUrl();//getting current url
        String[] tokens = getUrl.split("/");//
        System.out.println(tokens[tokens.length-3]);
        GetShipaIdApiCall.setDeliveryID(tokens[tokens.length-3]); //getting shipa id from url
        LoginDpApiCall.makeLoginApiCall();
        CreateOtpApiCall.createOtpApiCall();
        String dpAccessToken = PutOTPApiCall.OTPApiCall();
        String shipaOrderNum = GetShipaIdApiCall.makeShipaIdApiCall(dpAccessToken);
        ShipaInitiateEventApiCall.makeShipaInitiateEventApiCall(dpAccessToken, shipaOrderNum, "initiated");
        ShipaInitiateEventApiCall.makeShipaInitiateEventApiCall(dpAccessToken, shipaOrderNum, "failed");

    }




}
