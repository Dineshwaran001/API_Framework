package org.RestAPi.pojos.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Booking {

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("firstname")
    @Expose
    private String firstname;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("lastname")
    @Expose
    private String lastname;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("totalprice")
    @Expose
    private Integer totalprice;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("depositpaid")
    @Expose
    private Boolean depositpaid;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("bookingdates")
    @Expose
    private Bookingdates bookingdates;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("additionalneeds")
    @Expose
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

}
