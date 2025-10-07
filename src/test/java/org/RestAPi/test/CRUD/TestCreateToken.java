package org.RestAPi.test.CRUD;

import io.restassured.RestAssured;
import org.RestAPi.base.BaseTest;
import org.RestAPi.endPoints.APIConstants;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test
    public void testToken_Post(){
        //Preparation of request
        requestSpecification.basePath(APIConstants.AUTH_URL);

        //making the request
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setAuthPayload()).log().all().post();

        //Extraction --> JSON String to Java Object
        String verifyToken = payloadManager.getTokenFromAuthResponse(response.asString());

        //Validation of the Request
        assertActions.verifyStringKeyNotNull(verifyToken);

    }
}
