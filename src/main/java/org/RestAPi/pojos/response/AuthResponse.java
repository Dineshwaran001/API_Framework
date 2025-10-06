package org.RestAPi.pojos.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AuthResponse {
    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
