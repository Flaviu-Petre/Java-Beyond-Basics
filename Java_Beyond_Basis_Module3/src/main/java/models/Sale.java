package models;

public class Sale {
    private String productName;
    private double saleAmount;
    private String saleDate;
    private int customerId;

    public Sale(String productName, double saleAmount, String saleDate, int customerId) {
        this.productName = productName;
        this.saleAmount = saleAmount;
        this.saleDate = saleDate;
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
