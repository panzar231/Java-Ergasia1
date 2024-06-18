package model;

public class Enrollment implements PriceList {
    private int uniqueCode2;
    private String athleteName2;
    private int dateOfEnrollment;
    private int monthlyCost2;
    private int saleOfAthlete;

    public double calculateTotalPrice() {

        return 0;
    }

    public int getUniqueCode2() {
        return uniqueCode2;
    }

    public void setUniqueCode2(int uniqueCode2) {
        this.uniqueCode2 = uniqueCode2;
    }

    public String getAthleteName2() {
        return athleteName2;
    }

    public void setAthleteName2(String athleteName2) {
        this.athleteName2 = athleteName2;
    }

    public int getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(int dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public int getMonthlyCost2() {
        return monthlyCost2;
    }

    public void setMonthlyCost2(int monthlyCost2) {
        this.monthlyCost2 = monthlyCost2;
    }

    public int getSaleOfAthlete() {
        return saleOfAthlete;
    }

    public void setSaleOfAthlete(int saleOfAthlete) {
        this.saleOfAthlete = saleOfAthlete;
    }

}
