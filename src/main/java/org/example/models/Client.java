package org.example.models;

public class Client {
    private int id;
    private int salesID;

    public Client(int id, int salesID) {
        this.id = id;
        this.salesID = salesID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }
}
