package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class Medications {

    @SerializedName("copay")
    private String copay;

    @SerializedName("medicationRequestId")
    private int medicationRequestId;


   /* @SerializedName("isOTCProduct")
    private boolean isOTCProduct;

    @SerializedName("isRemoved")
    private boolean isRemoved;

    @SerializedName("id")
    private int id;

    @SerializedName("newQuantity")
    private int newQuantity;

    @SerializedName("previousQuantity")
    private int previousQuantity;*/






    public  String getCopay()
    {
        return copay;
    }

    public void setCopay(String copay)
    {
        this.copay=copay;
    }

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/


    public int getMedicationRequestId() {
        return medicationRequestId;
    }

    public void setMedicationRequestId(int medicationRequestId) {
        this.medicationRequestId = medicationRequestId;
    }



}

