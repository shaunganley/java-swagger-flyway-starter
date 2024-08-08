package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProjectRequest {
    private final int projectId;
    private final String projectName;
    private final int value;
    private final boolean isCompleted;
    private final int clientId;
    private final int techLeadId;

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getValue() {
        return value;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getClientId() {
        return clientId;
    }

    public int getTechLeadId() {
        return techLeadId;
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
