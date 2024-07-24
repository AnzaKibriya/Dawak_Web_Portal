package APICalls;

import okhttp3.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static Helper.BaseClass.accessTokens;
import static Helper.BaseClass.client;

public class UploadFileAPICall {
    static String filePath = Path.of(System.getProperty("user.dir"), "/src/main/resources/dummy.pdf").toString();
    static String apiUrl = "https://dawak-apim-training.azure-api.net/dawak-auth/api/user/upload-file";
    public static String makeUploadFileAPICall() {
        File file = new File(filePath);
        RequestBody fileBody = RequestBody.create(file, MediaType.parse("application/pdf"));
        MultipartBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), fileBody)
                .build();
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("Authorization", "Bearer " + accessTokens)
                .post(requestBody)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            JSONObject jsonResponse = new JSONObject(response.body().string());
            if (response.isSuccessful()) {
                System.out.println("File uploaded successfully: " + jsonResponse);
                JSONObject data = jsonResponse.getJSONObject("data");
                return data.getString("url");
            } else {
                System.out.println("File upload failed: " + response.code() + " " + response.message());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

