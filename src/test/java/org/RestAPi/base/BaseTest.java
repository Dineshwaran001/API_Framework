package org.RestAPi.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.RestAPi.asserts.AssertActions;
import org.RestAPi.endPoints.APIConstants;
import org.RestAPi.modules.PayloadManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    //CommonTOAll TestCase
    // we use BASEUrl , ContentType , - Json - common
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;


    @BeforeTest
    public void setup() {
        System.out.println("Starting of the test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

//        requestSpecififcation = RestAssured.given();
//        requestSpecififcation.baseUri(APIConstants.BASE_URL); // this will call from endpoints package
//        requestSpecififcation.contentType(ContentType.JSON).log().all();

        // same above written on the code again written using specBuilder
        //Before Running your request what are the important building blocks are required
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all(); // this is must

    }

    public String getToken() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL).basePath(APIConstants.AUTH_URL);

        //Setting the Payload
        String payload = payloadManager.setAuthPayload();

        //make the request to get te token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();

        //Extract the token
        String token = payloadManager.getTokenFromAuthResponse(response.asString());
        return token;
    }

    @AfterTest()
    public void tearDown() {
        System.out.println("Ending of the test");

    }

}
