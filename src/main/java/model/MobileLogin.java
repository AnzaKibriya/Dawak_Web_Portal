package model;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static Helper.BaseClass.client;

public class MobileLogin {

    public static String makeLoginApiCall() {

        String jsonBody = "{\"deviceToken\": \"b03b93096f6da089\", \"password\": \"Akhil@2929\", \"userName\": \"+971502201010\"}";

        // Request
        Request request = new Request.Builder()
                .url("https://dawak-apim-uat.azure-api.net/dawak-auth/api/auth/v3/mobile-login")
                .addHeader("deviceType", "android")
                .addHeader("devicePlayerId", "1b68739e-d137-40f7-8100-1a854e5c9769")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("accept-language", "en")
                .post(RequestBody.create(MediaType.parse("application/json"), jsonBody))
                .build();

        // Execute the request
        try {
            Response response = client.newCall(request).execute();

            // Handle the response
            if (response.isSuccessful()) {
                System.out.println("Request successful");
                System.out.println(response.body().string());
            } else {
                System.out.println("Request failed: " + response.code() + " " + response.message());
            }
        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
        }


        return jsonBody;
    }

    }
