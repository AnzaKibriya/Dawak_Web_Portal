package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.OrderCancel;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static Helper.BaseClass.*;

public class OrdercalcelAPICall {

    private static final String API_URL = BaseClass.propertyFile("config", "url")+"/dawak-patient/api/dashboard/patient-order-cancel";


    public static String ordercancelAPI() {
        try {
             OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(90, TimeUnit.SECONDS) // Set connection timeout to 30 seconds
                    .build();
             MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            OrdercalcelAPICall ordercalcelAPICall = new OrdercalcelAPICall();
            String jsonPayload = gson.toJson(ordercalcelAPICall.getordercancel(processInstanceId, id));
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
                test.log(Status.PASS, "cancel order API called successfully");


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

    public OrderCancel getordercancel(int processInstanceid, String id) {
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getResourceAsStream("/Ordercancel.json")))) {
            Gson gson = new Gson();
            OrderCancel result = gson.fromJson(reader, OrderCancel.class);
            int encounterid=Integer.parseInt(id);
            result.setId(encounterid);
            result.setProcessInstanceId(processInstanceid);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
