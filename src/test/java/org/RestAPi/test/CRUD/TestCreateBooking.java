package org.RestAPi.test.CRUD;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.RestAPi.pojos.response.BookingResponse;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {
    @Test(groups ="QA", priority = 1)
    @Owner("Dineshwaran")
    @Description("#TC1 this testcase is to verify the Create Booking")
    public void CreateBookingPositive(){
        System.out.println("This is the Testcase");

//basepath is coming from RestAssured
        //setup and Making Request
        requestSpecififcation.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response= RestAssured.given(requestSpecififcation)
                .when().body(payloadManager.CreatePayLoadString()).log().all().post();// create payload call from payload manager

        System.out.println("String-->"+ response.asString());// this will print response as String

        // in Payload manager you can chech this functions
        // Extraction (Deserializing)                  // booking response is the extraction part
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //Verification part
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Dinesh");
        assertActions.verifyIntegerKeyNotNull(bookingResponse.getBookingid());
    }
}
