package org.example.models;

public class Client {
    private int clientId;
    private String clientName;
    private SalesEmployee salesEmployee;

    public Client(int clientId, String clientName, SalesEmployee salesEmployee) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.salesEmployee = salesEmployee;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public SalesEmployee getSalesEmployee() {
        return salesEmployee;
    }

    public void setSalesEmployee(SalesEmployee salesEmployee) {
        this.salesEmployee = salesEmployee;
    }
}
