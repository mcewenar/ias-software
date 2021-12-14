package com.iassoftware.products.domain;

public class Product {
    //Privates attribute that restrict access since other class or Package. Then, we create getters
    //and setters for accessing to this.
    private String referenceId;
    private String productName;
    private int amount;
    private boolean existence;

    //Product's constructor
    public Product(String referenceId, String productName, int amount, boolean existence) {
        this.referenceId = referenceId;
        this.productName = productName;
        this.amount = amount;
        this.existence = existence;
    }

    public String getReferenceId() {

        return referenceId;
    }

    public String getProductName() {

        return productName;
    }

    public int getAmount() {

        return amount;
    }

    public void setReferenceId(String referenceId) {

        this.referenceId = referenceId;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public void setAmount(int amount) {

        this.amount = amount;
    }

    public boolean isExistence() {
        return existence;
    }

    public void setExistence(boolean existence) {
        this.existence = existence;
    }

    //This is an override polymorphism that allow us parsing objects to String.
    @Override
    public String toString() {

        return super.toString();
    }


}
