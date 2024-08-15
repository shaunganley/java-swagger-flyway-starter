package org.example.models;

public class ProjectRequest {
    int projectId;

    public ProjectRequest(final int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(final int projectId) {
        this.projectId = projectId;
    }
}
