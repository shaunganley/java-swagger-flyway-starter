package org.example.models;

public class ClientResponse {
    private final int clientId;
    private final String clientName;
    private final int salesEmployeeId;

    public ClientResponse(final int clientId, final String clientName,
                          final int salesEmployeeId) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.salesEmployeeId = salesEmployeeId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }
}
