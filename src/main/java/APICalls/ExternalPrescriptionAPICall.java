package APICalls;

import com.google.gson.Gson;
import model.ExternalPrescription;
import model.PrescriptionRequest;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;

import static Helper.BaseClass.accessTokens;
import static Helper.BaseClass.client;

public class ExternalPrescriptionAPICall {
    static String apiUrl = "https://dawak-apim-uat.azure-api.net/dawak-patient/api/external-prescription/v2/upload";

    public static void makeExternalPrescriptionAPICall(String cardFront, String cardBack, String prescriptionFile){
        MediaType mediaType = MediaType.parse("application/json");
        Gson gson = new Gson();
        ExternalPrescriptionAPICall externalPrescriptionAPICall = new ExternalPrescriptionAPICall();
        String jsonPayload = gson.toJson(externalPrescriptionAPICall.getExternalPrescription(cardFront, cardBack, prescriptionFile));
        RequestBody body = RequestBody.create(jsonPayload, mediaType);
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + accessTokens)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("Request was successful: " + response.body().string());
            } else {
                System.out.println("Request failed: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public ExternalPrescription getExternalPrescription(String cardFront, String cardBack, String prescriptionFile) {
        try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream("/ExternalPrescription.json"))) {
            Gson gson = new Gson();
            ExternalPrescription result = gson.fromJson(reader, ExternalPrescription.class);
            result.setInsuranceCardBack(cardBack);
            result.setInsuranceCardFront(cardFront);
            result.setPrescriptionFiles(Collections.singletonList(prescriptionFile));
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
