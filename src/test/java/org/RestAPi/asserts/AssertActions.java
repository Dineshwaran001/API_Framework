package org.RestAPi.asserts;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


public class AssertActions {

    public void verifyResponseBody(String actual, String expected, String description){
        Assert.assertEquals(actual,expected,description);
    }

    public void verifyResponseBody(int actual, int expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    //below will verify the status code
    public void verifyResponseCode(Response response, Integer expected){
            Assert.assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKey(String KeyExpect,String KeyActual){
        assertThat(KeyExpect).isNotNull();
        assertThat(KeyExpect).isNotBlank();
        assertThat(KeyExpect).isEqualTo(KeyActual);

    }
    public void verifyIntegerKeyNotNull(Integer keyExpect) {
        assertThat(keyExpect).isNotNull();
    }

    public void verifyStringKeyNotNull(String keyExpect) {
        assertThat(keyExpect).isNotNull();
    }
}
