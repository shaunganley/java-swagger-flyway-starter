package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private int empId;
    private String name;
    private double salary;
    private String bankAccNo;
    private String nino;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(final int empId) {
        this.empId = empId;
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

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(final String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getNino() {
        return nino;
    }

    public void setNino(final String nino) {
        this.nino = nino;
    }

    @JsonCreator
    public EmployeeRequest(
            final @JsonProperty("employeeID") int empId,
            final @JsonProperty("name") String name,
            final @JsonProperty("salary") double salary,
            final @JsonProperty("BankAccountNumber") String bankAccNo,
            final @JsonProperty("nationalInsuranceNumber") String nino) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
    }
}

