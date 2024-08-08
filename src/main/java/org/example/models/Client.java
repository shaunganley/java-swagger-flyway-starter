package org.example.models;

public class Client {
    private final int clientId;
    private final String clientName;
    private final SalesEmployee salesEmployee;

    public Client(final int clientId, final String clientName,
                  final SalesEmployee salesEmployee) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.salesEmployee = salesEmployee;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public SalesEmployee getSalesEmployee() {
        return salesEmployee;
    }

}
