package org.example.models;

public class DeliveryEmployee {
    private int id;
    private String name;
    private double salary;
    private int bankAccount;
    private String nI;

    public DeliveryEmployee(final int id, final String name,
                            final double salary, final int bankAccount,
                            final String nI) {
        this.setId(id);
        this.setName(name);
        this.setSalary(salary);
        this.setBankAccount(bankAccount);
        this.setnI(nI);
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(final int bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getnI() {
        return nI;
    }

    public void setnI(final String nI) {
        this.nI = nI;
    }
}
