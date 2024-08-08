package org.example.models;

public class Project {
    private int projectId;
    private int clientId;
    private String techLead;
    private double value;

    public Project(final int projectId, final int clientId,
                   final String techLead, final double value) {
        this.projectId = projectId;
        this.clientId = clientId;
        this.techLead = techLead;
        this.value = value;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(final int projectId) {
        this.projectId = projectId;
    }

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

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }
}
