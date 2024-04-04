package Pages;

import model.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static Helper.BaseClass.webJavascriptExecutor;

public class ReadyForDelivery {
    WebDriver driver;
    @FindBy(xpath = "//span[text()=' Ready for Delivery ']")
    WebElement readyDelivery;
    @FindBy(xpath = "//i[@mattooltip='Detail']")
    WebElement details;

    public ReadyForDelivery(WebDriver Driver) {
        driver = Driver;
    }

    public void deliveryFunctionality(String ID) throws InterruptedException {
        webJavascriptExecutor().executeScript("arguments[0].click();", readyDelivery);   // opening ready for delivery tab
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
        Thread.sleep(7000);
        String dpAccessToken = PutOTPApiCall.OTPApiCall();
        String shipaOrderNum = GetShipaIdApiCall.makeShipaIdApiCall(dpAccessToken);
        ShipaInitiateEventApiCall.makeShipaInitiateEventApiCall(dpAccessToken, shipaOrderNum, "initiated");
        ShipaInitiateEventApiCall.makeShipaInitiateEventApiCall(dpAccessToken, shipaOrderNum, "completed");

    }
}
