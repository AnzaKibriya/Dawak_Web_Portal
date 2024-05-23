package Pages;

import Helper.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    public static LoginCP LoginCP() {
        LoginCP pg = new LoginCP(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static OrderDetails OrderDetails() {
        OrderDetails pg = new OrderDetails(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static Home Home() {
        Home pg = new Home(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static WebCommon WebCommon() {
        WebCommon pg = new WebCommon(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static Mailinator Mailinator() {
        Mailinator pg = new Mailinator(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }


    public static LoginDP LoginDP() {
        LoginDP pg = new LoginDP(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static HomeDP HomeDP() {
        HomeDP pg = new HomeDP(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static OrderDetailsDP OrderDetailsDP() {
        OrderDetailsDP pg = new OrderDetailsDP(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static Logout Logout() {
        Logout pg = new Logout(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static NavigationsCP NavigationsCP() {
        NavigationsCP pg = new NavigationsCP(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static NavigationsDP NavigationsDP() {
        NavigationsDP pg = new NavigationsDP(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }


    public static Profile Profile() {
        Profile pg = new Profile(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static ReadyForDelivery ReadyForDelivery() {
        ReadyForDelivery pg = new ReadyForDelivery(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static PatientInformation PatientInformation() {
        PatientInformation pg = new PatientInformation(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static PatientInformations PatientInformations() {
        PatientInformations pg = new PatientInformations(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }


    public static Dispatched Dispatched() {
        Dispatched pg = new Dispatched(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static LoginCallCentre LoginCallCentre() {
        LoginCallCentre pg = new LoginCallCentre(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static HomePageCallCentre HomePageCallCentre() {
        HomePageCallCentre pg = new HomePageCallCentre(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static OrderDetailsCallCentre OrderDetailsCallCentre() {
        OrderDetailsCallCentre pg = new OrderDetailsCallCentre(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static LoginFrontLine LoginFrontLine() {
        LoginFrontLine pg = new LoginFrontLine(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static HomepageFrontLine HomepageFrontLine() {
        HomepageFrontLine pg = new HomepageFrontLine(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }

    public static OrderDetailsFrontLine OrderDetailsFrontLine() {
        OrderDetailsFrontLine pg = new OrderDetailsFrontLine(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;

    }

    public static CallCentreNavigations CallCentreNavigations()
    {
        CallCentreNavigations pg = new CallCentreNavigations(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;


    }

    public static ExternalPrescription ExternalPrescription() {

        ExternalPrescription pg  = new ExternalPrescription(BaseClass.driver);
        PageFactory.initElements(BaseClass.driver, pg);
        return pg;
    }
}
