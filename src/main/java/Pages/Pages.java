package Pages;

import Helper.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    public static LoginCP LoginCP() {
        LoginCP pg = new LoginCP(BaseClass.driver);
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

}
