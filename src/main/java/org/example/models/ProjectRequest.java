package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {
    private int projectId;
    private String projectName;
    private int value;
    private boolean isCompleted;
    private int clientId;
    private int techLeadId;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(final int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(final String projectName) {
        this.projectName = projectName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(final boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(final int clientId) {
        this.clientId = clientId;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(final int techLeadId) {
        this.techLeadId = techLeadId;
    }

    @JsonCreator ProjectRequest(
            @JsonProperty("ProjectID") final int projectId,
            @JsonProperty("ProjectName") final String projectName,
            @JsonProperty("IsCompleted") final boolean isCompleted,
            @JsonProperty("ClientID") final int clientId,
            @JsonProperty("`Value`") final int value,
            @JsonProperty("TechLeadID") final int techLeadId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.isCompleted = isCompleted;
        this.clientId = clientId;
        this.value = value;
        this.techLeadId = techLeadId;
    }
}
