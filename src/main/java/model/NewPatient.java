package model;

import com.google.gson.annotations.SerializedName;

public class NewPatient {

    @SerializedName("EID")
    private String EID;

    @SerializedName("MRN")
    private String MRN;

    @SerializedName("patientRelationId")
    private int patientRelationId;


    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }
}
