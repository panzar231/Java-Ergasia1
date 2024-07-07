package model;

import java.util.Date;

public class Enrollment implements PriceList {

    private int code;
    private int athleteCode;
    private Date date;
    private double cost;
    private double ekptosi;

    public Enrollment(int code, int athleteCode, double cost) {
        this.code = code;
        this.athleteCode = athleteCode;
        this.date = new Date();
        this.cost = cost;
        this.ekptosi = 0.0;
    }

    public double calculateTotalPrice() {
        return cost;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAthleteCode() {
        return athleteCode;
    }

    public void setAthleteCode(int athleteCode) {
        this.athleteCode = athleteCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getEkptosi() {
        return ekptosi;
    }

    public void setEkptosi(double ekptosi) {
        this.ekptosi = ekptosi;
    }

}
