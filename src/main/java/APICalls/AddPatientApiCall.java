package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.Delivery;
import model.NewPatient;
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

public class AddPatientApiCall {

    private static final String API_URL = BaseClass.propertyFile("config", "url")+"/dawak-patient/api/patient/v2/create-patient";
    public static String AddPatientApiCal() {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            AddPatientApiCall addPatientApiCall = new AddPatientApiCall();
            String jsonPayload = gson.toJson(addPatientApiCall.getpatient());
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
                JSONObject data = jsonResponse.getJSONObject("data");
                 mobileNumber = data.getString("mobileNumber");
                  patientId=data.getInt("patientId");
                  System.out.println(patientId);
                System.out.println(mobileNumber);
                test.log(Status.PASS, "Add patient API called successfully");
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

    public NewPatient getpatient() {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/AddPatient.json"))) {
            Gson gson = new Gson();
            NewPatient result = gson.fromJson(reader, NewPatient.class);
            result.setEID(generatedEID);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
