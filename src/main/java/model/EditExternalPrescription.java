package model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EditExternalPrescription {
    @SerializedName("deliveryAddressId")
    private int deliveryAddressId;

    @SerializedName("insuranceCardBack")
    private String insuranceCardBack;

    @SerializedName("insuranceCardFront")
    private String insuranceCardFront;
    @SerializedName("patientId")
    private int patientId;

    @SerializedName("insurancePlanName")
    private String insurancePlanName;

    @SerializedName("paymentType")
    private int paymentType;

    @SerializedName("prescriptionFiles")
    private List<String> prescriptionFiles;


    @SerializedName("prescriptionId")
    private int prescriptionId;

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


    // Getter and Setter for deliveryAddressId
    public int getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(int deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    // Getter and Setter for insuranceCardBack
    public String getInsuranceCardBack() {
        return insuranceCardBack;
    }

    public void setInsuranceCardBack(String insuranceCardBack) {
        this.insuranceCardBack = insuranceCardBack;
    }

    // Getter and Setter for insuranceCardFront
    public String getInsuranceCardFront() {
        return insuranceCardFront;
    }

    public void setInsuranceCardFront(String insuranceCardFront) {
        this.insuranceCardFront = insuranceCardFront;
    }

    // Getter and Setter for patientId
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    // Getter and Setter for paymentType
    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    // Getter and Setter for prescriptionFiles
    public List<String> getPrescriptionFiles() {
        return prescriptionFiles;
    }
    public String getInsurancePlanName() {
        return insurancePlanName;
    }

    public void setInsurancePlanName(String insurancePlanName) {
        this.insurancePlanName = insurancePlanName;
    }

    public void setPrescriptionFiles(List<String> prescriptionFiles) {
        this.prescriptionFiles = prescriptionFiles;
    }
}
