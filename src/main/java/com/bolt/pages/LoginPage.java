package com.bolt.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public void openLoginPage() {
        navigateTo("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public boolean isLoginSuccess() {
        return getCurrentUrl().contains("inventory");
    }
}
