package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRequest {
    private int clientId;
    private String clientName;
    private int salesEmployeeId;

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

    @JsonCreator ClientRequest(
            @JsonProperty("ClientID") final int clientId,
            @JsonProperty("ClientName") final String clientName,
            @JsonProperty("SalesEmpID") final int salesEmployeeId) {
                this.clientId = clientId;
                this.clientName = clientName;
                this.salesEmployeeId = salesEmployeeId;
    }
}
