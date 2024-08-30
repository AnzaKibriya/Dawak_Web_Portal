package APICalls;
import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.security.Key;
import java.util.concurrent.TimeUnit;

import static Helper.BaseClass.*;

public class GetTaskIdAPICall {



    public static String getOrderApiCall() throws InterruptedException {

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
                    .url(BaseClass.propertyFile("config", "url") +"/dawak-patient/api/dashboard/get-orders?orderId="+OrderId)
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
                test.log(Status.PASS, "Order API called successfully");
                JSONObject dataArray = jsonResponse.getJSONObject("data");
                JSONArray resultArray=dataArray.getJSONArray("result");
                JSONObject firstResult = resultArray.getJSONObject(0);
                // Extract taskId
                taskids = firstResult.getInt("taskId");
                // Print the taskId
                System.out.println("Task ID: " + taskId);




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
