package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.Delivery;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static Helper.BaseClass.*;

public class DeliveryRefillAPI {

    private static final String API_URL = BaseClass.propertyFile("config", "url")+"/dawak-patient/api/dashboard/v2/patient-accept-reject-order";

    public static String deliveryApiCall() {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            DeliveryRefillAPI DeliveryRefillAPICall = new DeliveryRefillAPI();
            String jsonPayload = gson.toJson(DeliveryRefillAPICall.getDelivery(taskId, id));
            System.out.println(jsonPayload);
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(API_URL)
                    .header("Authorization", "Bearer " + accessTokens)
                    .addHeader("deviceType", "android")
                    .addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("accept-language", "en")
                    .post(RequestBody.create(jsonPayload, MediaType.parse("application/json")))
                    .build();
            // Execute the request
            Response response = client.newCall(request).execute();
            // Handle the response
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());
                System.out.println("Request successful");
                System.out.println(jsonResponse);
                test.log(Status.PASS, "Delivery API called successfully");
            } else {
                System.out.println("Request failed: " + response.code() + " " + response.message());
                Assert.fail();

            }
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            Assert.fail();

        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
            Assert.fail();

        }
        return null;

    }

    public Delivery getDelivery(String taskId, String id) {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/DeliveryRefill.json"))) {
            Gson gson = new Gson();
            Delivery result = gson.fromJson(reader, Delivery.class);
            result.setTaskId(taskId);
            result.setId(id);
            result.setPatientId(patientId);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
