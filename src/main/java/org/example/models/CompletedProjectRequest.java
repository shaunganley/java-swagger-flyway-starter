package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompletedProjectRequest {
    private int clientId;
    private String techLead;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(final int clientId) {
        this.clientId = clientId;
    }

    public String getTechLead() {
        return techLead;
    }

    public void setTechLead(final String techLead) {
        this.techLead = techLead;
    }

    @JsonCreator
    public CompletedProjectRequest(
            @JsonProperty("clientId") final int clientId,
            @JsonProperty("techLead") final String techLead) {
        this.clientId = clientId;
        this.techLead = techLead;
    }
}
