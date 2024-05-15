package APICalls;

import com.aventstack.extentreports.Status;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static Helper.BaseClass.*;

public class GetShipaIdApiCall {
    static String shipaOrderNum;
    static String deliveryID;


    public static String makeShipaIdApiCall(String AUTH_TOKEN) {
        try {
            String apiUrl = "https://dawak-apim-uat.azure-api.net/dawak-patient/api/shipa/get-delivery-details?encounterId=" + getDeliveryID();
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
                JSONArray dataArray = jsonResponse.getJSONArray("data");
                JSONObject dataObject = dataArray.getJSONObject(0);
                shipaOrderNum = dataObject.getString("shippaOrderNum");
                System.out.println("Shippa Order Number: " + shipaOrderNum);
                test.log(Status.PASS, "GetShipaIdApi  called successfully");


            } else {
                System.out.println("API call failed!");
                System.out.println("Response: " + response.body().string());
            }
            return shipaOrderNum;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setDeliveryID(String deliveryID) {
        GetShipaIdApiCall.deliveryID = deliveryID;
    }

    public static String getDeliveryID() {
        return deliveryID;
    }

}
