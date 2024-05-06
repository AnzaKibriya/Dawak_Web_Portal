package APICalls;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.CreateOtpDp;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static Helper.BaseClass.client;
import static Helper.BaseClass.test;

public class CreateOtpApiCall {
    static String apiUrl = "https://dawak-apim-uat.azure-api.net/dawak-auth/api/auth/createOtp";
    public static void createOtpApiCall() {
        try{
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            CreateOtpApiCall createOtpApiCall = new CreateOtpApiCall();
            String jsonPayload = gson.toJson(createOtpApiCall.getCreateOtp());
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .post(RequestBody.create(jsonPayload, MediaType.parse("application/json")))
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());
//                JSONObject data = jsonResponse.getJSONObject("data");
//                accessToken = data.getString("access_token");
                test.log(Status.PASS, "create OTP API called successfully");

            } else {
                System.out.println("API call failed!");
                System.out.println("Response: " + response.body().string());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public CreateOtpDp getCreateOtp() {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/CreateOTP.json"))) {
            CreateOtpDp result = new Gson().fromJson(reader, CreateOtpDp.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
