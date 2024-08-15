package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DeliveryEmployeeDetailsRequest {
    private String name;
    private BigDecimal salary;
    private String bankAccountNumber;
    private String nin;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(final String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(final String nin) {
        this.nin = nin;
    }

    @JsonCreator
    public DeliveryEmployeeDetailsRequest(
            final @JsonProperty("name") String name,
            final @JsonProperty("salary")
            BigDecimal salary,
            final @JsonProperty("bankAccountNumber")
            String bankAccountNumber,
            final @JsonProperty("nin")
            String nin) {
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nin = nin;
    }
}
