package com.bolt.actions;

import com.bolt.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginActions {

    private final LoginPage loginPage;

    @Autowired
    public LoginActions(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void openApplication() {
        loginPage.openLoginPage();
    }

    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    public boolean isLoginSuccessful() {
        return loginPage.isLoginSuccess();
    }
}
