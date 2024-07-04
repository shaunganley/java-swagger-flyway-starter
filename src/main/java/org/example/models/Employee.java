package org.example.models;

//abstract class since no Employee objects are ever created
public abstract class Employee {

    private int id;
    private String name;
    private double salary;
    private String bankNumber;
    private String nationalInsuranceNumber;


    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        //Here we can put validation code to ensure the insurance number is in correct format
        //first two characters are letters, following 6 are digits, last is a letter
        //total length == 9
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        //validation code, ensuring it meets at least one international bank number format
        this.bankNumber = bankNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        //ensure the number isn't negative
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //add max length validation
        this.name = name;
    }

    public Employee(int id, String name, double salary, String bankNumber, String nationalInsuranceNumber) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;

    }




}
