package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.Medications;
import model.Payment;
import model.Reschedule;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static Helper.BaseClass.*;

public class InsurenceRescheduleAPI {

    public static String rescheduleAPIcall() {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            InsurenceRescheduleAPI InsurenceRescheduleAPIs = new InsurenceRescheduleAPI();
            String jsonPayload = gson.toJson(InsurenceRescheduleAPIs.getreschedule());
            System.out.println(jsonPayload);
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url")+"/dawak-patient/api/patient/v2/update-medications")
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

    public Reschedule getreschedule() {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/Reschedule.json"))) {
            Gson gson = new Gson();
            Reschedule result = gson.fromJson(reader, Reschedule.class);
            int i=Integer.parseInt(id);
            int tid=Integer.parseInt(taskId);

            result.setEncounterId(i);
            result.setTaskId(tid);
           //  Example value for MedicationRequestId
           for (Medications medications : result.getMedications()) {
              //  medications.setId(medicationRequestId3);

            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




}
