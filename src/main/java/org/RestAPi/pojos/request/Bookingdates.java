package org.RestAPi.pojos.request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Bookingdates {
    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("checkin")
    @Expose
    private String checkin;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("checkout")
    @Expose
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}
