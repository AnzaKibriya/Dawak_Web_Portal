package APICalls;

import com.aventstack.extentreports.Status;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import static Helper.BaseClass.client;
import static Helper.BaseClass.test;

public class CallMeBackAPICall {
    static String apiUrl = "https://dawak-apim-uat.azure-api.net/dawak-patient/api/dashboard/call-me-back";

    public static void makeCallMeBackAPICall(String AUTH_TOKEN) {
        try {
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());
                System.out.println(jsonResponse);
                test.log(Status.PASS, "Call Me Back  called successfully");
            } else {
                System.out.println("API call failed!");
                System.out.println("Response: " + response.body().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
