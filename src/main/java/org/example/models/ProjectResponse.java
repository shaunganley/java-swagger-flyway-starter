package org.example.models;

public class ProjectResponse {
    private int projectId;
    private String projectName;
    private int value;
    private boolean isCompleted;
    private int clientId;
    private int techLeadId;

    public ProjectResponse(int projectId, String projectName,
                           int value, boolean isCompleted,
                           int clientId, int techLeadId) {
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

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
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
}
