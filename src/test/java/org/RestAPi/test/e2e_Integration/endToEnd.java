package org.RestAPi.test.e2e_Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.RestAPi.pojos.request.Booking;
import org.RestAPi.pojos.response.BookingResponse;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class endToEnd extends BaseTest {

    @Test(priority = 1)
    @Owner("Dineshwaran")
    @Description("This TC is to verify the Create Booking")
    public void CreateBooking(ITestContext iTestContext) {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
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
    public void VerifyBookingId(ITestContext iTestContext) {
        // it will return Integer so we store in Integer and get attribute to get the value from Listener
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        // here we add the                     /booking in this area and booking id in this area
        String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGET);

        requestSpecification.basePath(basePathGET);
        //making the request
        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Extraction (Deserializing)
        Booking booking = payloadManager.getResponseFromJsonBooking(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());
    }

    @Test(priority = 3)
    @Owner("Dineshwaran")
    @Description("#TC2 This TC is to verify the Update the bookingId")
    public void tokenGeneration(ITestContext iTestContext) {

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        //get token method having the generate token whenever we need it come from Base Test
        String token = getToken();
        iTestContext.setAttribute("token", token);
// store base path in a string and call usingrequest specification
        String basePathPutPatch = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPutPatch);

        requestSpecification.basePath(basePathPutPatch);
        // making request and serialization using method name in the body
        response = RestAssured.given(requestSpecification).cookie("token", token)
                .when().body(payloadManager.fullUpdateBookingPayload()).put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Extraction (Deserializing)
        Booking booking = payloadManager.getResponseFromJsonBooking(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());
        assertActions.verifyStringKey(booking.getFirstname(), "Dinesh");
    }

    @Test(priority = 4)
    @Owner("Dineshwaran")
    @Description("#TC2 This TC is to verify the delete in the bookingId")
    public void deleteBooking(ITestContext iTestContext) {
        //below code is used  to pass the booking id and token
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = (String) iTestContext.getAttribute("token");

        //if token is not available use below code
//        if (token.equalsIgnoreCase(null)) {
//            token = getToken();
//        }
        String basePathDELETE = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        requestSpecification.basePath(basePathDELETE).cookie("token", token);

        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);


    }
}
