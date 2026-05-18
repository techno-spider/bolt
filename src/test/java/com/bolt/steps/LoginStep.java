package com.bolt.steps;

import com.bolt.actions.LoginActions;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

@Slf4j
public class LoginStep {

    private final LoginActions loginActions;

    public LoginStep(LoginActions loginActions) {
        this.loginActions = loginActions;
    }

    @Given("user is on login page")
    public void openLoginPage() {
        loginActions.openApplication();
        log.info("URL launched");
    }

    @When("user logs in with {string} and {string}")
    public void login(String user, String pass) {
        loginActions.login(user, pass);
        log.info("User logged in successfully");
    }

    @Then("user should see inventory page")
    public void verifyLogin() {
        Assertions.assertTrue(loginActions.isLoginSuccessful());
        log.info("User is on home page");
    }
}
