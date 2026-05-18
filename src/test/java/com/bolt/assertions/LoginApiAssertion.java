package com.bolt.assertions;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class LoginApiAssertion {

    public static void verifyStatusCode(Response response, int expectedStatus) {

        Assertions.assertEquals(expectedStatus, response.statusCode());
    }

    public static void verifyTokenIsPresent(String token) {

        Assertions.assertNotNull(token);
    }
}
