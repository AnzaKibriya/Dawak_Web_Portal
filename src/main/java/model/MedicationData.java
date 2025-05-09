package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MedicationData {

    @SerializedName("medications")
    private List<Medication> medications = new ArrayList<>();


    // Method to add medication to the list
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

}
