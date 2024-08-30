package model;
import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static Helper.BaseClass.*;
public class ListAPICall {



    public static String makeListApiCall() throws InterruptedException {

        client = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS) // Adjust timeout as needed
                .readTimeout(50, TimeUnit.SECONDS) // Adjust timeout as needed
                .build();
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            JsonObject emptyJson = new JsonObject();
            // Convert the empty JSON object to a string
            String jsonBody = gson.toJson(emptyJson);
            // Create the request body
            RequestBody body = RequestBody.create(jsonBody, mediaType);
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url") +"/dawak-patient/api/dashboard/get-prescriptions?key=1")
                    .header("Authorization", "Bearer " + accessTokens)
                    .addHeader("deviceType", "android")
                    .addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("accept-language", "en")
                    .post(body)
                    .build();

            // Execute the request
            Response response = client.newCall(request).execute();
            // Handle the response
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());
                System.out.println("Request successful");
                System.out.println(jsonResponse);
                test.log(Status.PASS, "List API called successfully");
                JsonObject jsonObject = gson.fromJson(String.valueOf(jsonResponse), JsonObject.class);
                JsonArray dataArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : dataArray) {
                    JsonObject dataObject = element.getAsJsonObject();
                    try {
                        String encounterId = dataObject.get("prescriptionNumber").getAsString();
                        System.out.println(encounterId);
                        System.out.println(prescriptionOrderID);
                        if (encounterId.equals(prescriptionOrderID)) {
                           // taskId = dataObject.get("taskId").getAsString();
                          //  id = dataObject.get("id").getAsString();
                            processInstanceId = dataObject.get("prescriptionId").getAsInt();
                            //System.out.println(taskId);
                           // System.out.println(id);
                            System.out.println(processInstanceId);
                        }


                    } catch (NullPointerException e) {
                        e.printStackTrace();

                    }
                }


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
}
