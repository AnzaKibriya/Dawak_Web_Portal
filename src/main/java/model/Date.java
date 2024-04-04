package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Date {



    @Setter
    @SerializedName("currentDate")
    private String currentDate;

    @Setter
    @SerializedName("encounterId")
    private String encounterId;


}
