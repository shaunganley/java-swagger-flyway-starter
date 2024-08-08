package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

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

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(int techLeadId) {
        this.techLeadId = techLeadId;
    }

    @JsonCreator ProjectRequest(
            @JsonProperty("ProjectID") int projectId,
            @JsonProperty("ProjectName") String projectName,
            @JsonProperty("IsCompleted") boolean isCompleted,
            @JsonProperty("ClientID") int clientId,
            @JsonProperty("`Value`") int value,
            @JsonProperty("TechLeadID") int techLeadId){
        this.projectId = projectId;
        this.projectName = projectName;
        this.isCompleted = isCompleted;
        this.clientId = clientId;
        this.value = value;
        this.techLeadId = techLeadId;
    }
}
