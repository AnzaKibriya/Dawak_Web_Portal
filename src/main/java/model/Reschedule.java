package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Reschedule {

    @SerializedName("encounterId")
    private int encounterId;

    @SerializedName("isBrandChanged")
    private boolean isBrandChanged;
    private List<Medications> medications;

    @SerializedName("taskId")
    private int taskId;



    public List<Medications> getMedications() {
        return medications;
    }

    public void setMedications(List<Medications> medications) {
        this.medications = medications;
    }





    public Reschedule()
    {
        medications = new ArrayList<>();
        medications.add(new Medications());
        medications.add(new Medications());

    }

    public int getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(int encounterId) {
        this.encounterId = encounterId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
