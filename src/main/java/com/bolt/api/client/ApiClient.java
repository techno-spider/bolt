package com.bolt.api.client;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiClient {

    @Value("${reqres.api.key}")
    private String apiKey;

    public RequestSpecification request() {

        return RestAssured
                .given()
                .header("x-api-key", apiKey)
                .header("Content-Type", "application/json");
    }
}
