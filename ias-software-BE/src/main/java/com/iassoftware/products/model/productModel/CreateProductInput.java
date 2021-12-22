package com.iassoftware.products.model.productModel;


public class CreateProductInput {
    private String productName;
    private int price;
    private String description;
    public CreateProductInput() {
    }
    public CreateProductInput(String productName, int price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;


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
