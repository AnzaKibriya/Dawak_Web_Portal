package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class OrderCancel {

    @SerializedName("customReason")
    private String customReason;

    public String getCustomReason() {
        return customReason;
    }

    public void setCustomReason(String customReason) {
        this.customReason = customReason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(int processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    @SerializedName("id")
    private int id;

    @SerializedName("processInstanceId")
    private int processInstanceId;
    @SerializedName("reasonId")
    private int reasonId;


}
