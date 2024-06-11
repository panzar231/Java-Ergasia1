package model;

public class Payment implements PriceList {
    private int uniqueCode3;
    private int dateOfPayment;
    private String paymentMethod;
    private String paymentInfo;
    private int totalCost;

    public double calculateTotalPrice() {

        return 0;
    }

    public int getUniqueCode3() {
        return uniqueCode3;
    }

    public void setUniqueCode3(int uniqueCode3) {
        this.uniqueCode3 = uniqueCode3;
    }

    public int getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(int dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}