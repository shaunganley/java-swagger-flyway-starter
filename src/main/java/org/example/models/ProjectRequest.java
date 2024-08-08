package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
            @JsonProperty("ProjectID") final int projectId,
            @JsonProperty("ProjectName") final String projectName,
            @JsonProperty("IsCompleted") final boolean isCompleted,
            @JsonProperty("ClientID") final int clientId,
            @JsonProperty("`Value`") final int value,
            @JsonProperty("TechLeadID") final int techLeadId){
        this.projectId = projectId;
        this.projectName = projectName;
        this.isCompleted = isCompleted;
        this.clientId = clientId;
        this.value = value;
        this.techLeadId = techLeadId;
    }
}
