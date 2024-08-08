package org.example.models;

public class ProjectRequest {
    private String techLead;

    public ProjectRequest(final String techLead) {
        this.techLead = techLead;
    }

    public String getTechLead() {
        return techLead;
    }

    public void setTechLead(final String techLead) {
        this.techLead = techLead;
    }
}
