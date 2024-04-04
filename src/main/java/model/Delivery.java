package model;

import com.google.gson.annotations.SerializedName;

public class Delivery {

    @SerializedName("addressId")
    private int addressId;

    @SerializedName("id")
    private String id;

    @SerializedName("isAccepted")
    private boolean isAccepted;

    @SerializedName("patientId")
    private int patientId;

    @SerializedName("taskId")
    private String taskId;

    public String getId() {return id; }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskid) {
        this.taskId = taskid;
    }

    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}

