package APICalls;
import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.GetOrder;
import model.Medications;
import model.Order;
import model.Payment;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import static Helper.BaseClass.*;
import static Helper.BaseClass.processInstanceId;

public class GetOrderIdAPICall {

    public static String order() {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            GetOrderIdAPICall order = new GetOrderIdAPICall();
            String jsonPayload = gson.toJson(order.getOrders());
            System.out.println(jsonPayload);
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url")+"/dawak-patient/api/dashboard/get-orders-list?prescriptionId="+processInstanceId)
                    .header("Authorization", "Bearer " + accessTokens)
                    .addHeader("deviceType", "android")
                    .addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("accept-language", "en")
                    .post(body)
                    .build();
            // Execute the request
            try (Response response = client.newCall(request).execute()) {
                // Handle the response
                if (response.isSuccessful()) {
                    JSONObject jsonResponse = new JSONObject(response.body().string());
                    System.out.println("Request successful");
                    System.out.println(jsonResponse);
                    test.log(Status.PASS, "payment API called successfully");
                    JSONArray dataArray = jsonResponse.getJSONArray("data");
                    JSONObject firstDataObject = dataArray.getJSONObject(0);
                    JSONArray ordersArray = firstDataObject.getJSONArray("orders");
                    JSONObject firstOrderObject = ordersArray.getJSONObject(0);
                    // Extract orderId as a string
                     OrderId = String.valueOf(firstOrderObject.getInt("orderId"));

                    // Print the extracted orderId
                    System.out.println("Order ID: " + OrderId);

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

    public GetOrder getOrders() throws IOException {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/Orders.json"))) {
            Gson gson = new Gson();
            String id = Integer.toString(processInstanceId);

            GetOrder result = gson.fromJson(reader, GetOrder.class);
            result.setPrescriptionNumber(id);
            //  result.setId(id);

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
