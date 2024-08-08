package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {

    private String name;
    private double salary;
    private String bankNumber;
    private String nationalInsurance;

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

    @JsonCreator
    public DeliveryEmployeeRequest(@JsonProperty("name") final String name,
                                   @JsonProperty("salary") final double salary,
                                   @JsonProperty("bankNumber")
                                       final String bankNumber,
                                   @JsonProperty("nationalInsurance")
                                       final String nationalInsurance) {
        this.name = name;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.nationalInsurance = nationalInsurance;
    }
}
