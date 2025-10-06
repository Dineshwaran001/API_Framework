package org.RestAPi.test.CRUD;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.RestAPi.pojos.response.BookingResponse;
import org.testng.annotations.Test;

public class TestingRandomPayload_CreateBooking extends BaseTest {
    @Test
    @Owner("Dineshwaran")
    @Description("#TC5 is to Verify giving Random Payload")
    public void CreateBookingPositive(){
        System.out.println("This is the Testcase");


        requestSpecififcation.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response= RestAssured.given(requestSpecififcation)//changed Body payload class
                .when().body(payloadManager.CreatePayLoadFakerJS()).log().all().post();// create payload call from payload manager

        System.out.println("String-->"+ response.asString());// this will print response as String

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);
    }
}
