package models;

public class SaleSummary {
    private String productName;
    private double totalSalesAmount;

    public SaleSummary(String productName, double totalSalesAmount) {
        this.productName = productName;
        this.totalSalesAmount = totalSalesAmount;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }
}
