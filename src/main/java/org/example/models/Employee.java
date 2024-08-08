package org.example.models;

public class Employee {

    private int empId;
    private String name;
    private double salary;
    private String bankAccNo;
    private String nino;
    private Sales sales;
    private Delivery delivery;


    public Employee(final int empId, final String name,
                    final double salary, final String bankAccNo,
                    final String nino, final Sales sales) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
        this.sales = sales;

    }

    public Employee(final int empId, final String name,
                    final double salary, final String bankAccNo,
                    final String nino, final Delivery delivery) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
        this.delivery = delivery;

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
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getNino() {
        return nino;
    }

    public void setNino(final String nino) {
        this.nino = nino;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(final String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }
    public Sales getSales() {
        return sales;
    }

    public void setSales(final Sales sales) {
        this.sales = sales;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(final Delivery delivery) {
        this.delivery = delivery;
    }
}


