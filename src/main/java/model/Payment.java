package model;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    @Setter
    @Getter
    @SerializedName("addressId")
    private int addressId;

    @Setter
    @Getter
    @SerializedName("deliveryDate")
    private String deliveryDate;

    @Setter
    @Getter
    @SerializedName("deliveryFee")
    private String deliveryFee;


    @Setter
    @Getter
    @SerializedName("deliveryTime")
    private String deliveryTime;


    @Setter
    @Getter
    @SerializedName("id")
    private int id;
    @Setter
    @Getter
    @SerializedName("isConfirmed")
    private String isConfirmed;

    @Setter
    @Getter
    private List<Medications> medications;

    @Setter
    @Getter
    @SerializedName("copay")
    private String copay;


    @Setter
    @Getter
    @SerializedName("patientId")
    private String patientId;

    @SerializedName("paymentMode")
    private int paymentMode;

    @Setter
    @Getter
    @SerializedName("taskId")
    private int taskId;


    @Setter
    @Getter
    @SerializedName("totalAmount")
    private String totalAmount;

    @Setter
    @Getter
    @SerializedName("warehouseId")
    private String warehouseId;

public Payment()
{
    medications = new ArrayList<>();
    medications.add(new Medications());
    medications.add(new Medications());

}



   /* @SerializedName("medications")
    private List<Medication> medications = new ArrayList<>();*/



    // Method to add medication to the list
   /* public void addMedication(Medication medication) {
        medications.add(medication);
    }*/



}
