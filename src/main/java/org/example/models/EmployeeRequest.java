package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class EmployeeRequest {
    private final int employeeId;
    private final String employeeName;
    private final BigDecimal salary;
    private final int bankAccountNumber;
    private final int nationalInsuranceNumber;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public int getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    @JsonCreator EmployeeRequest(
            @JsonProperty("EmployeeID") int employeeId,
            @JsonProperty("Name") String employeeName,
            @JsonProperty("Salary") BigDecimal salary,
            @JsonProperty("BankAccountNumber") int bankAccountNumber,
            @JsonProperty("NationalInsuranceNumber") int nationalInsuranceNumber){
                this.employeeId = employeeId;
                this.employeeName = employeeName;
                this.salary = salary;
                this.bankAccountNumber = bankAccountNumber;
                this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
