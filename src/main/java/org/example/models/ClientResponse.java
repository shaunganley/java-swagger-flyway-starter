package org.example.models;

public class ClientResponse {
    private int clientId;
    private String clientName;
    private int salesEmployeeId;

    public ClientResponse(final int clientId, final String clientName,
                          final int salesEmployeeId) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.salesEmployeeId = salesEmployeeId;
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

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }
}
