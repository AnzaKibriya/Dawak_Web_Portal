package Helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import okhttp3.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;


public class BaseClass {
    public static ChromeDriver driver;
    public static ExtentTest test;
    public static ExtentReports extent;
    public static String storestring;
    public static Properties prop;
    public static WebDriverWait webWait;
    public static String prescriptionOrderID;
    public static String accessToken;
    public static OkHttpClient client;
    public static String loginWindow;
    public static String otpText;
    public static SoftAssert softAssert;
    public static String emiratesID;
    public static String formattedDate;
    public static String formattedDateAPI;

    public static String paymentDate;


    public static String accessTokens;
    public static String taskId;

    public static String id;

    public static DateTimeFormatter DateFormat;

    public static DateTimeFormatter DateFormatpayment;


    public static int medicationRequestId;

    public static int medicationRequestId2;

    public static int medicationRequestId3;

    public static int processInstanceId;


    public static String propertyFile(String PropFileName, String stringName) {
        try {
            FileInputStream fis = new FileInputStream("./src/main/resources/" + PropFileName + ".properties");
            prop.load(fis);
            storestring = prop.getProperty(stringName);
        } catch (Exception e) {
            System.out.println("File Not Found :" + e.getMessage());
        }
        return storestring;
    }

    public static String screenshot(String filename) throws IOException {
        File obj = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = new File("target//" + filename + ".PNG").getAbsolutePath();
        Files.copy(obj, new File("./target//" + filename + ".PNG"));
        return destination;
    }

    @BeforeSuite
    public void setUp() {
        client = new OkHttpClient();
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        extent = new ExtentReports();
        prop = new Properties();
        webWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        loginWindow = driver.getWindowHandle();
        driver.get("https://dawakportaluat.z1.web.core.windows.net/#/auth/login");
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/Dawak.html");
        extent.attachReporter(extentSparkReporter);
    }


    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case failed", ExtentColor.RED));
            test.fail(result.getThrowable());
            String destination = screenshot("Failed Scenario Screenshot");
            test.fail(result.getThrowable()).addScreenCaptureFromPath(destination);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test case passed", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + "Test case skipped", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    public static JavascriptExecutor webJavascriptExecutor() {
        return  driver;
    }

    public static String generateRandomNumericString() {
        int length = 8;
        StringBuilder numericString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            prescriptionOrderID = String.valueOf(numericString.append(digit));
        }
        return prescriptionOrderID;
    }
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formatte = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         DateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateFormatpayment = DateTimeFormatter.ofPattern("yyyy-MM-dd");



        formattedDate=now.format(formatte);
        formattedDateAPI=now.format(DateFormat);
        paymentDate=now.format(DateFormatpayment);
        System.out.println(formattedDateAPI);

        return now.format(formatter);
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}

