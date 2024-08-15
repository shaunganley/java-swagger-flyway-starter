package org.example.models;

import java.math.BigDecimal;

public abstract class Employees {
    // name, salary, bank account number and national insurance number
    private int id;
    private String name;
    private BigDecimal salary;
    private String bankAccountNumber;
    private String nin;

    public Employees(final int id, final String name, final BigDecimal salary,
                    final String bankAccountNumber, final String nin) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nin = nin;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(final String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(final String nin) {
        this.nin = nin;
    }
}
