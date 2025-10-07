package org.RestAPi.test.E2E;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.RestAPi.pojos.request.Booking;
import org.RestAPi.pojos.response.BookingResponse;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateDeleteVerify extends BaseTest {

    @Test(priority = 1)
    @Description("This TC is to verify the Create Booking")
    @Owner("Dineshwaran")
    public void createBooking(ITestContext iTestContext) {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.CreatePayLoadString()).log().all().post();

        System.out.println("String-->" + response.asString());
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }


    @Test(priority = 2)
    @Description("This TC is to Delete Booking")
    @Owner("Dineshwaran")
    public void deleteBooking(ITestContext iTestContext) {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();// this is to generate and get token
        iTestContext.setAttribute("token", token);
        String basePathDELETE = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;

        requestSpecification.basePath(basePathDELETE).cookie("token",token);
        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);
    }

    @Test(priority = 3)
    @Description("This TC is to Delete Booking")
    @Owner("Dineshwaran")
    public void verifyTheDeletedBooking(ITestContext iTestContext) {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String VerifyingDeletedBooking = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;

        requestSpecification.basePath(VerifyingDeletedBooking);
        response = RestAssured.given(requestSpecification).when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);


    }

}
