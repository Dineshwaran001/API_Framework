package org.RestAPi.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.RestAPi.pojos.request.Auth;
import org.RestAPi.pojos.request.Booking;
import org.RestAPi.pojos.request.Bookingdates;
import org.RestAPi.pojos.response.AuthResponse;
import org.RestAPi.pojos.response.BookingResponse;

public class PayloadManager {
    Gson gson;
    Faker faker;

    //Convert Java Object into JSON String to use as a Payload
    //Serialization
    public String CreatePayLoadString() {
        Booking booking = new Booking();
        booking.setFirstname("Dinesh");
        booking.setLastname("Cruise");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        //Convert Java Object --> Json
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

        //convert jsON String to java Object so that we can Verify response body

    }

    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        //below code is everything we have done we map with this BookingResponse class(Getter setter)
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public String setAuthPayload() {
        // calling the auth class from request package to set username password
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadStringAuth = gson.toJson(auth);
        System.out.println("payLoad set to the" + "--> " + jsonPayloadStringAuth);
        return jsonPayloadStringAuth;
    }

    public String getTokenFromAuthResponse(String tokenResponse) {
        gson = new Gson();
        //below code is everything we have done -->we map with this AuthResponse class(Getter setter)
        AuthResponse authResponse1 = gson.fromJson(tokenResponse,AuthResponse.class);
        //here we use reference dot get token in return
        return authResponse1.getToken();

    }

    public String CreatePayLoadFakerJS() {
        faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1,1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        //Convert Java Object --> Json
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

        //convert jsON String to java Object so that we can Verify response body

    }
}
