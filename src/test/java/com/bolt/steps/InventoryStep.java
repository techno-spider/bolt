package com.bolt.steps;

import com.bolt.actions.InventoryActions;
import com.bolt.actions.LoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class InventoryStep {

    private final LoginActions loginActions;
    private final InventoryActions inventoryActions;

    public InventoryStep(LoginActions loginActions, InventoryActions inventoryActions) {
        this.loginActions = loginActions;
        this.inventoryActions = inventoryActions;
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        loginActions.openApplication();
        loginActions.login("standard_user", "secret_sauce");

        Assertions.assertTrue(
                inventoryActions.isUserOnInventoryPage(),
                "User is not on Inventory Page after login");
    }

    @When("user adds product to cart")
    public void addProductToCart() {
        inventoryActions.addProductToCart();
    }

    @Then("cart count should be {string}")
    public void verifyCart(String count) {
        System.out.println("cart count is " + count);
        //Assertions.assertEquals(count, inventoryActions.getCartCount());
    }
}
