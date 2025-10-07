package org.RestAPi.test.CRUD;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.testng.annotations.Test;

public class TestPingRequest extends BaseTest {

    @Test
    @Description("This TC is to Verify Ping request")
    public void ping_Request(){
        requestSpecification.basePath(APIConstants.PING_URL);

        response = RestAssured.given(requestSpecification).when().get(); // this is get request

        validatableResponse= response.then().log().all();

        validatableResponse.statusCode(201);

    }
}
