package com.example.rice.Entity;

public class Cart_entity {
    private String name;
    private int imageId;
    private String stock;
    private String cost;
    private String num;

    public Cart_entity(String name, int imageId, String stock, String cost, String num) {
        this.name = name;
        this.imageId = imageId;
        this.stock = stock;
        this.cost = cost;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
