package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.PrescriptionRequest;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Helper.BaseClass.client;
import static Helper.BaseClass.test;

public class RefillsApiCall {

    private static final String API_URL = "https://dawak-apim-training.azure-api.net/dawak-portal/api/prescription/detail";

    public static void makePrescriptionApiCall(String AUTH_TOKEN, String orderID) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            PrescriptionApiCall prescriptionApiCall = new PrescriptionApiCall();
            String jsonPayload = gson.toJson(prescriptionApiCall.getPrescriptionRequest(orderID));
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
                    .build();
            Response response = client.newCall(request).execute();
            int  a = response.code();
            if (response.isSuccessful()) {
                System.out.println("API call successful!");
                System.out.println("Response: " + response.body().string());
                test.log(Status.PASS, "Prescription created successfully");

            } else {
                System.out.println("API call failed!");
                System.out.println("Response: " + response.body().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PrescriptionRequest getPrescriptionRequest(String orderID) {
        try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream("/RefillOrder.json"))) {
            Gson gson = new Gson();
            PrescriptionRequest result = gson.fromJson(reader, PrescriptionRequest.class);
            result.getOrder().setPhysicianEncounterId(orderID);
            result.getOrder().setPhysicianOrderDate(getCurrentDateTime());
            result.getOrder().setOrderVisitDate(getCurrentDateTime());
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

}
