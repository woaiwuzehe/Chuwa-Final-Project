package com.example.item_service.payload;

public class InventoryUpdateRequest {
    private String itemId;
    private int newInventory;

    // Getter & Setter
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public int getNewInventory() {
        return newInventory;
    }
    public void setNewInventory(int newInventory) {
        this.newInventory = newInventory;
    }
}
