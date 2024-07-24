package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static Helper.BaseClass.*;
import static Helper.BaseClass.medicationRequestId;

public class DashboardPrescriptionAPICall {

    public static String dashBoardPrescriptionAPICall()
    {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url")+"/dawak-patient/api/dashboard/prescriptions?encounterId="+id)
                    .header("Authorization", "Bearer " + accessTokens)
                    .addHeader("deviceType", "android")
                    .addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("accept-language", "en")
                    .build();

            // Execute the request
            Response response = client.newCall(request).execute();
            // Handle the response
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());
                System.out.println("Request successful");
                System.out.println(jsonResponse);
                test.log(Status.PASS, "Dashboard prescription API called successfully");
                try {
                    // Parse the JSON response
                    JSONArray medications = jsonResponse.getJSONObject("data")
                            .getJSONArray("result")
                            .getJSONObject(0)
                            .getJSONArray("medications");

                    // Extract and print medicationRequestId and copay amount
                    for (int i = 0; i < medications.length(); i++) {
                        JSONObject medication = medications.getJSONObject(i);
                        if(i==0) {
                          int  medicationRequestId1 = medication.getInt("medicationRequestId");
                          medicationRequestId=medicationRequestId1;
                            System.out.println("Medication Request ID: " + medicationRequestId1);

                        }
                        if(i==1)
                        {
                           int medicationRequestId = medication.getInt("medicationRequestId");
                           medicationRequestId2=medicationRequestId;
                            System.out.println("Medication Request ID2: " + medicationRequestId2);

                        }
                        if(i==2)
                        {
                            int medicationRequestId = medication.getInt("medicationRequestId");
                            medicationRequestId3=medicationRequestId;
                            System.out.println("Medication Request ID3: " + medicationRequestId3);


                        }
                        int copay = medication.getInt("copay");

                        System.out.println("Medication Request ID: " + medicationRequestId);
                        System.out.println("Copay Amount: " + copay);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            } else {
                System.out.println("Request failed: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
        }
        return null;


    }
}
