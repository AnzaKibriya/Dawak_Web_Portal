package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Delivery {
    @SerializedName("addressId")
    private int addressId;

    @SerializedName("medications")
    private List<Integer> medications;

    @SerializedName("patientId")
    private int patientId;

    @SerializedName("prescriptionId")
    private int prescriptionId;

    public Delivery() {
        this.medications = new ArrayList<>();
    }

    // Getters and Setters
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public List<Integer> getMedications() {
        return medications;
    }

    public void setMedications(List<Integer> medications) {
        this.medications = medications;
    }

    public void addMedication(int medication) {
        this.medications.add(medication);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
}

