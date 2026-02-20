package org.theMungai;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("c-name") // used for the serialization and deserialization process.
    private String customerName;

    @JsonProperty("p-name")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    /*
    * Getters -> Used to serialize Java objects to JSON.
    * Setters -> Used to deserialize JSON back to Java objects.
    * */
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
