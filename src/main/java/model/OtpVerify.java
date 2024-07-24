package model;

import com.google.gson.annotations.SerializedName;

public class OtpVerify {

    @SerializedName("mobileNumber")
    private String mobileNumber;

    @SerializedName("otp")
    private String otp;

    @SerializedName("patientId")
    private int patientId;


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
