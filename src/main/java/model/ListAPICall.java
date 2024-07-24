package model;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Helper.BaseClass.*;

public class ListAPICall {

    public static String makeListApiCall() {

        client = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS) // Adjust timeout as needed
                .readTimeout(50, TimeUnit.SECONDS) // Adjust timeout as needed
                .build();
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url")+"/dawak-patient/api/dashboard/v3/prescriptions?key=1")
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
                test.log(Status.PASS, "List API called successfully");
                JsonObject jsonObject = gson.fromJson(String.valueOf(jsonResponse), JsonObject.class);
                JsonArray dataArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : dataArray) {
                    JsonObject dataObject = element.getAsJsonObject();
                    try {
                        String encounterId = dataObject.get("encounterId").getAsString();
                        if (encounterId.equals(prescriptionOrderID)) {
                            taskId = dataObject.get("taskId").getAsString();
                            id = dataObject.get("id").getAsString();
                            processInstanceId=dataObject.get("processInstanceId").getAsInt();
                            System.out.println(taskId);
                            System.out.println(id);
                            System.out.println(processInstanceId);
                        }

                    } catch (NullPointerException e) {
                        e.printStackTrace();

                    }
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
