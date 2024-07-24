package APICalls;

import com.google.gson.Gson;
import model.EditExternalPrescription;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;

import static Helper.BaseClass.*;

public class EditExternalPrescriptionAPICall {
    static String apiUrl = " https://dawak-apim-uat.azure-api.net/dawak-patient/api/external-prescription/v2/edit";

    public static String makeEditExternalPrescriptionAPICall(String cardFront, String cardBack, String prescriptionFile) {
        MediaType mediaType = MediaType.parse("application/json");
        Gson gson = new Gson();
        EditExternalPrescriptionAPICall editExternalPrescriptionAPICall = new EditExternalPrescriptionAPICall();
        String jsonPayload = gson.toJson(editExternalPrescriptionAPICall.getExternalPrescription(cardFront, cardBack, prescriptionFile));
        RequestBody body = RequestBody.create(jsonPayload, mediaType);
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + accessTokens)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject jsonResponse = new JSONObject(response.body().string());
            if (response.isSuccessful()) {
                System.out.println("Request was successful: " + jsonResponse);
                JSONObject data = jsonResponse.getJSONObject("data");
                return data.getString("dawakPrescriptionNumber");
            } else {
                System.out.println("Request failed: " + response.code() + " " + response.message());
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public EditExternalPrescription getExternalPrescription(String cardFront, String cardBack, String prescriptionFile) {
        try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream("/EditExternalPrescription.json"))) {
            Gson gson = new Gson();
            EditExternalPrescription result = gson.fromJson(reader, EditExternalPrescription.class);
            result.setInsuranceCardBack(cardBack);
            result.setInsuranceCardFront(cardFront);
            result.setPrescriptionFiles(Collections.singletonList(prescriptionFile));
           // result.setPrescriptionId(Integer.parseInt(id));
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
