package com.iassoftware.products.model.productModel;

public class UpdateProductInput {
    private String productName;
    private int price;
    private String description;
    public UpdateProductInput(String productName, int price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;

    }
    public UpdateProductInput() {
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}