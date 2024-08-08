package org.example.models;

import java.util.Date;

public class Employee {

    private int empId;
    private String name;
    private double salary;
    private String bankAccNo;
    private String nino;
    private Sales sales;
    private Delivery delivery;


    public Employee(int empId, String name, double salary, String bankAccNo, String nino, Sales sales) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
        this.sales = sales;

    }

    public Employee(int empId, String name, double salary, String bankAccNo, String nino, Delivery delivery) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bankAccNo = bankAccNo;
        this.nino = nino;
        this.delivery = delivery;

    }

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
    public String getNino() {
        return nino;
    }

    public void setNino (String nino) {
        this.nino = nino;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo (String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}


