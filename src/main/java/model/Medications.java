package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class Medications {

    @SerializedName("copay")
    private String copay;

    @SerializedName("medicationRequestId")
    private int medicationRequestId;

    public  String getCopay()
    {
        return copay;
    }

    public void setCopay(String copay)
    {
        this.copay=copay;
    }
    public int getMedicationRequestId() {
        return medicationRequestId;
    }

    public void setMedicationRequestId(int medicationRequestId) {
        this.medicationRequestId = medicationRequestId;
    }

}
