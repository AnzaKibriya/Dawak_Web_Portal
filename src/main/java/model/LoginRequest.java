package model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("deviceToken")
    private String deviceToken;

    @SerializedName("password")
    private String password;

    @SerializedName("userName")
    private String userName;

    // Constructor, getters, and setters
    public LoginRequest(String deviceToken, String password, String userName) {
        this.deviceToken = deviceToken;
        this.password = password;
        this.userName = userName;
    }

    // Getters and setters
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
