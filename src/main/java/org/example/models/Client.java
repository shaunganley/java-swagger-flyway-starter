package org.example.models;

public class Client {
    private int id;
    private int salesID;

    public Client(final int id, final int salesID) {
        this.id = id;
        this.salesID = salesID;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(final int salesID) {
        this.salesID = salesID;
    }
}
