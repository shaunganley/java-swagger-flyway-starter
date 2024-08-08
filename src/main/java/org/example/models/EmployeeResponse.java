package org.example.models;

public class EmployeeResponse {
    private int empId;
    private String name;
    private double salary;
    private String bankAccNo;
    private String nino;

    public EmployeeResponse(final int empId, final String name,
                            final double salary,
                            final String bankAccNo, final String nino) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
    }

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
        return empId;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(final String bankAccNo) {
        this.name = name;
    }

    public String getNino() {
        return bankAccNo;
    }

    public void setNino(final String nino) {
        this.name = name;
    }
}
