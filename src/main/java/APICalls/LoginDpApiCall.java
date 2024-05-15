package APICalls;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import model.LoginDP;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static Helper.BaseClass.*;

public class LoginDpApiCall {
    static String apiUrl = "https://dawak-apim-uat.azure-api.net/dawak-auth/api/auth/v2/web-login";
    public static void makeLoginApiCall() {
        try{
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            LoginDpApiCall loginDpApiCall = new LoginDpApiCall();
            String jsonPayload = gson.toJson(loginDpApiCall.getLoginDp());
            RequestBody body = RequestBody.create(jsonPayload, mediaType);
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .post(RequestBody.create(jsonPayload, MediaType.parse("application/json")))
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.body().string());
                System.out.println(jsonResponse);
                test.log(Status.PASS, "LoginDp API called successfully");

            } else {
                System.out.println("API call failed!");
                System.out.println("Response: " + response.body().string());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public LoginDP getLoginDp() {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/LoginDP.json"))) {
            LoginDP result = new Gson().fromJson(reader, LoginDP.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
