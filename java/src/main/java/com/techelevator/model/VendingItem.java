package com.techelevator.model;

public class VendingItem {
    private int id;
    private String name;
    private String type;
    private int price;
    private int inventory;
    private String imageUrl;

    public VendingItem(){
        id = -1;
        name = "Default name";
        type = "Default Type";
        price = -1;
        inventory = -1;
    }

    public VendingItem(int id, String name, String type, int price, int inventory) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
