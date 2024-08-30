package model;

import com.google.gson.annotations.SerializedName;

public class GetOrder {



    @SerializedName("prescriptionNumber")
    private String prescriptionNumber;

    // Constructor


    // Getter
    public String getPrescriptionNumber() {
        return prescriptionNumber;
    }

    // Setter
    public void setPrescriptionNumber(String prescriptionNumber) {
        this.prescriptionNumber = prescriptionNumber;
    }




}
