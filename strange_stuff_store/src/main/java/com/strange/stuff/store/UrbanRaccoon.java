package com.strange.stuff.store;

public class UrbanRaccoon extends Product {
    private String size;
    private String color;

    public UrbanRaccoon(String name, float price, int quantity, String description, String size, String color) {
        super(name, price, quantity, description);
        this.size = size;
        this.color = color;
    }

    // Getters and Setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
