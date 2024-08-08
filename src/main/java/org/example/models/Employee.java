package org.example.models;

import java.math.BigDecimal;

public class Employee {
    private final int employeeId;
    private final String employeeName;
    private final BigDecimal salary;
    private final int bankAccountNumber;
    private final int nationalInsuranceNumber;

    public Employee(final int employeeId, final String employeeName,
                    final BigDecimal salary, final int bankAccountNumber,
                    final int nationalInsuranceNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

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
}
