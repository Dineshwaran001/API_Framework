package org.RestAPi.pojos.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.RestAPi.pojos.request.Booking;


public class BookingResponse {
    // this annotation is used to mapping the payload
    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;

    // this annotation (@SerializedName)is used to mapping the payload
    @SerializedName("booking")
    @Expose
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
