package com.techelevator.model;

public class VendingItem {
    private int itemId;
    private String name;
    private String type;
    private int price;
    private int inventory;
    private String imageUrl;

    public VendingItem(){
        itemId = -1;
        name = "Default name";
        type = "Default Type";
        price = -1;
        inventory = -1;
    }

    public VendingItem(int itemId, String name, String type, int price, int inventory) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.inventory = inventory;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
