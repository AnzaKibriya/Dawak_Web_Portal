package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.Medications;
import model.Payment;
import model.RefillPayment;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static Helper.BaseClass.*;
import static Helper.BaseClass.taskId;

public class RefillPaymentAPI {

    public static String paymentAPICAll() {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            RefillPaymentAPI RefillPaymentAPICall = new RefillPaymentAPI();
            String jsonPayload = gson.toJson(RefillPaymentAPICall.getpayment());
            System.out.println(jsonPayload);
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url")+"/dawak-patient/api/dashboard/delivery-payment-confirmation")
                    .header("Authorization", "Bearer " + accessTokens)
                    .addHeader("deviceType", "android")
                    .addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("accept-language", "en")
                    .post(RequestBody.create(jsonPayload, MediaType.parse("application/json")))
                    .build();
            // Execute the request
            try (Response response = client.newCall(request).execute()) {
                // Handle the response
                if (response.isSuccessful()) {
                    JSONObject jsonResponse = new JSONObject(response.body().string());
                    System.out.println("Request successful");
                    System.out.println(jsonResponse);
                    test.log(Status.PASS, "payment API called successfully");

                } else {
                    System.out.println("Request failed: " + response.code() + " " + response.message());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
        }
        return null;

    }

    public RefillPayment getpayment() {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/Refillpayment.json"))) {
            Gson gson = new Gson();
            RefillPayment result = gson.fromJson(reader, RefillPayment.class);
            //  result.setId(id);
            int encounterid=Integer.parseInt(id);
            result.setId(encounterid);
            result.setDeliveryDate(paymentDate);
            int taskIdInteger=Integer.parseInt(taskId);
            result.setTaskId(taskIdInteger);
            result.setPatientId(patientId);
            int count=0;
            // Example value for MedicationRequestId
            for (Medications medications : result.getMedications()) {
                if (count == 0) {
                    //  medications.setMedicationRequestId(medicationRequestId);
                }
                if (count == 1) {

                    // medications.setMedicationRequestId(medicationRequestId2);

                }
                if (count == 2) {
                    //medications.setMedicationRequestId(medicationRequestId3);
                }
                count++;
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
