package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployee extends Employee {

    /**
     * Name JSON element.
     */
    @JsonProperty
    private String name;
    /**
     * NI Number JSON element.
     */
    @JsonProperty
    private String nationalInsurance;
    /**
     * Bank Account Number.
     */
    @JsonProperty
    private int bankAccountNo;
    @JsonProperty
    private double salary;
    @JsonProperty
    private double commissionRate;

    public SalesEmployee(
            final String empName,
            final String nino,
            final int bankAcct,
            final double sal,
            final double commRate) {
        this.name = empName;
        this.nationalInsurance = nino;
        this.bankAccountNo = bankAcct;
        this.salary = sal;
        this.commissionRate = commRate;
    }

    public String getEmpName() {
        return name;
    }

    public void setEmpName(final String empName) {
        this.name = empName;
    }

    public String getNationalInsurance() {
        return nationalInsurance;
    }

    public void setNationalInsurance(final String nino) {
        this.nationalInsurance = nino;
    }

    public int getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(final int bankAcct) {
        this.bankAccountNo = bankAcct;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final double commRate) {
        this.commissionRate = commRate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double sal) {
        this.salary = sal;
    }
}
