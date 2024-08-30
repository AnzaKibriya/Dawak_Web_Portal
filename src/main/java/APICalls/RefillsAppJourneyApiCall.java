package APICalls;

import Helper.BaseClass;
import com.google.gson.Gson;
import model.RefillRequest;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static APICalls.NewPatientApiCall.generateRandomEID;

public class RefillsAppJourneyApiCall extends BaseClass {

    static String apiUrl = BaseClass.propertyFile("config", "url")+"/dawak-portal/api/prescription/detail";

    public static void makeRefillsApiCall(String AUTH_TOKEN, String orderID) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            RefillsAppJourneyApiCall RefillsAppJourneyApiCalls = new RefillsAppJourneyApiCall();
            String jsonPayload = gson.toJson(RefillsAppJourneyApiCalls.getRefillsRequest(orderID));
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
                    .build();
            Response response = client.newCall(request).execute();
            int  a = response.code();
            if (response.isSuccessful()) {
                System.out.println("API call successful!");
                System.out.println("Response: " + response.body().string());
            } else {
                System.out.println("API call failed!");
                System.out.println("Response: " + response.body().string());
                Assert.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RefillRequest getRefillsRequest(String orderID) {
        try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream("/RefillAppJourney.json"))) {
            Gson gson = new Gson();
            generatedEID="784"+generateRandomEID();
            System.out.println(generatedEID);
            RefillRequest result = gson.fromJson(reader, RefillRequest.class);
            result.getRefillsOrder().setPharmacyEncounterId(orderID);
            result.getRefillsOrder().setPhysicianEncounterId(orderID);
            result.getRefillsOrder().getMedications().get(0).setPhysicianOrderId(orderID);
            result.getRefillsOrder().getMedications().get(0).setDispensedOrderId(orderID);
            result.getRefillsOrder().getMedications().get(0).setLastDispDate(getCurrentDateTime());
            result.getRefillsOrder().getMedications().get(0).setStartDate(getCurrentDateTime());
            result.getRefillsOrder().getMedications().get(0).setStopDate((getFutureDate()));
            result.getRefillsOrder().getMedications().get(0).setNextRefillDate(getCurrentDateTime());
            result.getRefillsOrder().setPhysicianOrderDate(getCurrentDateTime());
            result.getRefillsOrder().setOrderVisitDate(getCurrentDateTime());
            result.getPatient().setEid("784191113121365");
            result.getPatient().setMrn(orderID);
            result.getPatient().setCmrn(orderID);
            result.getPatient().setPhoneNumber("971502201010");
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return now.format(formatter);
    }
    public static String getFutureDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusDays(4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return future.format(formatter);
    }


}
