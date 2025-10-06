package org.RestAPi.pojos.request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Auth {
    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("username")
    @Expose
    private String username;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("password")
    @Expose
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
