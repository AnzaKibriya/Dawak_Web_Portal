package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class OrderCancel {

    @SerializedName("customReason")
    private String customReason;
    @Setter
    @Getter
    @SerializedName("id")
    private int id;

    @Setter
    @Getter
    @SerializedName("processInstanceId")
    private int processInstanceId;
    @SerializedName("reasonId")
    private int reasonId;


}
