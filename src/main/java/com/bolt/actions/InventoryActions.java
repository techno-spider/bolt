package com.bolt.actions;

import com.bolt.pages.InventoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryActions {

    private final InventoryPage inventoryPage;

    @Autowired
    public InventoryActions(InventoryPage inventoryPage) {
        this.inventoryPage = inventoryPage;
    }

    public boolean isUserOnInventoryPage() {
        return inventoryPage.isInventoryPageLoaded();
    }

    public void addProductToCart() {
        inventoryPage.addBackpackToCart();
    }

    public String getCartCount() {
        return inventoryPage.getCartCount();
    }
}
