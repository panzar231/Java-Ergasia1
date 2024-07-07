package model;

import java.util.Date;

public class Payment implements PriceList {

    private int code;
    private Date date;
    private String paymentMethod;
    private boolean isEnrollment;
    private int actionCode;
    private double total;

    public Payment(int code, boolean isEnrollment, int actionCode, double total) {
        this.code = code;
        this.date = new Date();
        this.paymentMethod = "CASH";
        this.isEnrollment = isEnrollment;
        this.actionCode = actionCode;
        this.total = total;
    }

    public double calculateTotalPrice() {
        return total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isEnrollment() {
        return isEnrollment;
    }

    public void setEnrollment(boolean isEnrollment) {
        this.isEnrollment = isEnrollment;
    }

    public int getActionCode() {
        return actionCode;
    }

    public void setActionCode(int actionCode) {
        this.actionCode = actionCode;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}