package org.example.models;

public class Project {
    private int projectId;
    private String projectName;
    private double projectValue;
    private int techLead;
    private int clientId;

    public Project(final int projectId, final String projectName,
                   final double projectValue,
                   final int techLead, final int clientId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.techLead = techLead;
        this.clientId = clientId;
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
}
