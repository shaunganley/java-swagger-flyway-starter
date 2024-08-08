package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private int empId;
    private String name;
    private double salary;
    private String bankAccNo;
    private String nino;

    public int getEmployeeId() {
        return empId;
    }

    public void setEmployeeId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankAccNo() { return bankAccNo;}

    public void setBankAccNo (String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getNino() { return nino;}

    public void setNino (String nino) {
        this.nino = nino;
    }
    @JsonCreator
    public EmployeeRequest(
            @JsonProperty("employeeID") int empId,
            @JsonProperty("name") String name,
            @JsonProperty("salary") double salary,
            @JsonProperty("BankAccountNumber") String bankAccNo,
            @JsonProperty("nationalInsuranceNumber") String nino)
    {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
    }
}

