package org.example.models;

public class ProjectResponse {
    private int projectId;
    private String projectName;
    private int value;
    private boolean isCompleted;
    private int clientId;
    private int techLeadId;

    public ProjectResponse(final int projectId, final String projectName,
                           final int value, final boolean isCompleted,
                           final int clientId, final int techLeadId) {
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

    public void setCompleted(final boolean completed) {
        this.isCompleted = completed;
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
}
