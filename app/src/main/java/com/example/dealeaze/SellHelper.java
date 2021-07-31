package com.example.dealeaze;

public class SellHelper {
    String product, description, price, contact;

    public SellHelper() {
    }

    public SellHelper(String product, String description, String price, String contact) {
        this.product = product;
        this.description = description;
        this.price = price;
        this.contact = contact;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

    