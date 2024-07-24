package APICalls;

import Helper.BaseClass;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

import static Helper.BaseClass.*;

public class LogoutAPICall {


    public static String logoutApiCall()
    {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .url(BaseClass.propertyFile("config", "url")+"/dawak-auth/api/auth/logout/799")
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
