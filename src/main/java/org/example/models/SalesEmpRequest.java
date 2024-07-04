package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmpRequest {
    private String name;
    private String nationalInsurance;
    private int bankAccountNo;
    private double salary;
    private double commissionRate;

    @JsonCreator
    public SalesEmpRequest(
            @JsonProperty final String empName,
            @JsonProperty final String nino,
            @JsonProperty final int bankAcct,
            @JsonProperty final double sal,
            @JsonProperty final double commRate) {
        this.name = empName;
        this.nationalInsurance = nino;
        this.bankAccountNo = bankAcct;
        this.salary = sal;
        this.commissionRate = commRate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double sal) {
        this.salary = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(final String empName) {
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
}
