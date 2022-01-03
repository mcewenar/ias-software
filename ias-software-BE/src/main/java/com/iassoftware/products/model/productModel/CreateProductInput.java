package com.iassoftware.products.model.productModel;


public class CreateProductInput {
    private String productName;
    private int price;
    private int amount;
    private String description;

    public CreateProductInput() {
    }
    public CreateProductInput(String productName, int amount ,int price, String description) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.description = description;


    }

    public int getAmount() {
        return amount;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
