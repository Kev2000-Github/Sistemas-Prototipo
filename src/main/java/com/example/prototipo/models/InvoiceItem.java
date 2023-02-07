package com.example.prototipo.models;

public class InvoiceItem {
    private String name;
    private int quantity;
    private float price;
    private String code;

    public InvoiceItem(String name, int quantity, float price, String code) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.code = code;
    }

    public InvoiceItem() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
