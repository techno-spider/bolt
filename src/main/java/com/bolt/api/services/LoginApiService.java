package com.bolt.api.services;

import com.bolt.api.client.ApiClient;
import com.bolt.api.models.LoginRequest;
import com.bolt.api.models.LoginResponse;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class LoginApiService {

    private final ApiClient apiClient;

    public LoginApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Response login(LoginRequest requestBody) {

        return apiClient
                .request()
                .body(requestBody)
                .post("https://reqres.in/api/login");
    }

    public LoginResponse getLoginResponse(Response response) {

        return response.as(LoginResponse.class);
    }
}
