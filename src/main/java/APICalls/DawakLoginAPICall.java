package APICalls;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.LoginRequest;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static Helper.BaseClass.*;

public class DawakLoginAPICall {

    private static final String API_URL = "https://dawak-apim-uat.azure-api.net/dawak-auth/api/auth/v3/mobile-login";

    public static String makeLoginApiCall() {
        client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS) // Adjust timeout as needed
                .readTimeout(30, TimeUnit.SECONDS) // Adjust timeout as needed
                .build();
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            DawakLoginAPICall dawakApiCall = new DawakLoginAPICall();
            String jsonPayload = gson.toJson(dawakApiCall.getLoginRequest());
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder().url(API_URL).addHeader("deviceType", "android").addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769").addHeader("Content-Type", "application/json").addHeader("Accept", "application/json").addHeader("accept-language", "en").post(RequestBody.create(jsonPayload, MediaType.parse("application/json"))).build();

            // Execute the request
            Response response = client.newCall(request).execute();

            // Handle the response
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());

                System.out.println("Request successful");
                System.out.println(jsonResponse);
                JSONObject data = jsonResponse.getJSONObject("data");
                accessTokens = data.getString("accessToken");
                fullName = data.getString("fullName");
                mobileUserPhoneNumber = data.getString("phoneNumber");
                test.log(Status.PASS, "Login API called successful");


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

    public LoginRequest getLoginRequest() {
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(this.getClass().getResourceAsStream("/DawakLogin.json")))) {
            LoginRequest result = new Gson().fromJson(reader, LoginRequest.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
