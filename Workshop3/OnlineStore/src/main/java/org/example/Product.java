package org.example;

public class Product {
    private int id;
    private String sKU;
    private String productName;
    private double price;
    private String department;

    public Product(int id, String sKU, String productName, double price, String department) {
        this.id = id;
        this.sKU = sKU;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getsKU() {
        return sKU;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }
}
