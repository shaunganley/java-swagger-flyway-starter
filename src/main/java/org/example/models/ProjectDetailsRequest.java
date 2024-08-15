package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDetailsRequest {
    private String projectName;
    private double projectValue;
    private int techLead;
    private int clientId;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(final String projectName) {
        this.projectName = projectName;
    }

    public double getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(final double projectValue) {
        this.projectValue = projectValue;
    }

    public int getTechLead() {
        return techLead;
    }

    public void setTechLead(final int techLead) {
        this.techLead = techLead;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(final int clientId) {
        this.clientId = clientId;
    }

    @JsonCreator
    public ProjectDetailsRequest(
            @JsonProperty("projectName") final String projectName,
            @JsonProperty("projectValue") final double projectValue,
            @JsonProperty("techLead") final int techLead,
            @JsonProperty("clientId") final int clientId) {
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.techLead = techLead;
        this.clientId = clientId;
    }
}
