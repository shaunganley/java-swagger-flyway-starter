package org.example.models;

import java.util.Date;

public class EmployeeResponse {
    private int empId;
    private String name;
    private double salary;
    private String bankAccNo;
    private String nino;

    public EmployeeResponse(int empId, String name, double salary, String bankAccNo, String nino)
    {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
    }
    public int getEmployeeId() {
        return empId;
    }
    public void setEmployeeId(int empId)
    {
        this.empId = empId;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSalary() {
        return empId;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getBankAccountNumber()
    {
        return bankAccNo;
    }

    public void setBankAccountNumber(String bankAccNo)
    {
        this.name = name;
    }

    public String getNationalInsuranceNumber()
    {
        return bankAccNo;
    }

    public void setNationalInsuranceNumber(String nino)
    {
        this.name = name;
    }
}
