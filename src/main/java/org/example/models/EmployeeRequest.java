package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class EmployeeRequest {
    private int employeeId;
    private String employeeName;
    private BigDecimal salary;
    private int bankAccountNumber;
    private int nationalInsuranceNumber;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(final int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(final int nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    @JsonCreator EmployeeRequest(
            @JsonProperty("EmployeeID") final int employeeId,
            @JsonProperty("Name") final String employeeName,
            @JsonProperty("Salary") final BigDecimal salary,
            @JsonProperty("BankAccountNumber") final int bankAccountNumber,
            @JsonProperty("NationalInsuranceNumber")
                final int nationalInsuranceNumber) {
                this.employeeId = employeeId;
                this.employeeName = employeeName;
                this.salary = salary;
                this.bankAccountNumber = bankAccountNumber;
                this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
