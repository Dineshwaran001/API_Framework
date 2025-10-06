package org.RestAPi.test.E2E;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.RestAPi.pojos.response.BookingResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class endToEnd extends BaseTest {

    @Test(priority = 1)
    @Owner("Dineshwaran")
    @Description("This TC is to verify the Create Booking")
    public void CreateBooking(ITestContext iTestContext) {
        requestSpecififcation.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecififcation)
                .when().body(payloadManager.CreatePayLoadString()).log().all().post();// create payload call from payload manager

        System.out.println("String-->" + response.asString());// this will print response as String
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        // in Payload manager you can chech this functions
        // Extraction (Deserializing)                  // booking response is the extraction part
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //Validation part
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Dinesh");
        assertActions.verifyIntegerKeyNotNull(bookingResponse.getBookingid());

        // this is used to pass the value to all the Testcases
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());
    }


    @Test(priority = 2)
    @Owner("Dineshwaran")
    @Description("#TC2 This TC is to verify the Booking")
    public void BookingCreation1(ITestContext iTestContext) {
        // it will return Integer so we store in Integer and get attribute to get the value from Listener
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

    }


}
