package org.example.models;

public class SalesEmployee {

    private int id;
    private String name;
    private double salary;
    private String bankNumber;
    private String nationalInsurance;
    private double commissionRate;

    public SalesEmployee(final int id, final String name, final double salary,
                         final String bankNumber,
                         final String nationalInsurance,
                         final double commissionRate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.nationalInsurance = nationalInsurance;
        this.commissionRate = commissionRate;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(final String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNationalInsurance() {
        return nationalInsurance;
    }

    public void setNationalInsurance(final String nationalInsurance) {
        this.nationalInsurance = nationalInsurance;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
