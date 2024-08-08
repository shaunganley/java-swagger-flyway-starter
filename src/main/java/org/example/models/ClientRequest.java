package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRequest {
    private final int clientId;
    private final String clientName;
    private final int salesEmployeeId;

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    @JsonCreator ClientRequest(
            @JsonProperty("ClientID") final int clientId,
            @JsonProperty("ClientName") final String clientName,
            @JsonProperty("SalesEmpID") final int salesEmployeeId){
                this.clientId = clientId;
                this.clientName = clientName;
                this.salesEmployeeId = salesEmployeeId;
    }
}
