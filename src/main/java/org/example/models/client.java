package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class client {
    @JsonProperty
    private int clientId;
    @JsonProperty
    private String clientName;
    @JsonProperty
    private String clientAddress;
    @JsonProperty
    private String clientPhoneNumber;

    public client(int clientId, String clientName, String clientAddress,
                  String clientPhoneNumber) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPhoneNumber = clientPhoneNumber;
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

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }
}
