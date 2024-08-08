package org.example.models;

public class ProjectResponse {
    private final int projectId;
    private final String projectName;
    private final int value;
    private final boolean isCompleted;
    private final int clientId;
    private final int techLeadId;

    public ProjectResponse(int projectId, String projectName, int value, boolean isCompleted, int clientId, int techLeadId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.value = value;
        this.isCompleted = isCompleted;
        this.clientId = clientId;
        this.techLeadId = techLeadId;
    }

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
}
