package com.bolt.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class InventoryPage extends BasePage {

    // Locators
    private final By inventoryContainer = By.id("inventory_container");
    private final By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.className("shopping_cart_badge");

    // Actions
    public boolean isInventoryPageLoaded() {
        return find(inventoryContainer).isDisplayed();
    }

    public void addBackpackToCart() {
        click(addToCartBackpack);
    }

    public String getCartCount() {
        return find(cartBadge).getText();
    }
}
