package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest {

    private String name;
    private double salary;
    private String bankNumber;
    private String nationalInsurance;
    private double commissionRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNationalInsurance() {
        return nationalInsurance;
    }

    public void setNationalInsurance(String nationalInsurance) {
        this.nationalInsurance = nationalInsurance;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @JsonCreator
    public SalesEmployeeRequest(@JsonProperty("name") String name,
                                   @JsonProperty("salary") double salary,
                                   @JsonProperty("bankNumber") String bankNumber,
                                   @JsonProperty("nationalInsurance") String nationalInsurance,
                                @JsonProperty("commissionRate") double commissionRate) {
        this.name = name;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.nationalInsurance = nationalInsurance;
        this.commissionRate = commissionRate;
    }
}
