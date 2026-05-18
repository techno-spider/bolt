package com.bolt.steps;

import com.bolt.api.models.LoginRequest;
import com.bolt.api.models.LoginResponse;
import com.bolt.api.services.LoginApiService;
import com.bolt.assertions.LoginApiAssertion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ApiLoginStep {

    private final LoginApiService loginApiService;
    private Response response;
    private LoginResponse loginResponse;

    public ApiLoginStep(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    @When("user sends login API request with {string} and {string}")
    public void loginApi(String email, String password) {
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);

        response = loginApiService.login(request);

        loginResponse =
                loginApiService.getLoginResponse(response);
    }

    @Then("API response status should be {int}")
    public void verifyStatus(int statusCode) {
        LoginApiAssertion.verifyStatusCode(response, statusCode);

        LoginApiAssertion.verifyTokenIsPresent(
                loginResponse.getToken()
        );
    }
}
