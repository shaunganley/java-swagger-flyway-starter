package org.example.models;

public class Client {
    private int id;
    private int salesEmpId;
    ProjectRequest projectRequest;

    public Client(final int id, final int salesEmpId,
                  final ProjectRequest projectRequest) {
        this.id = id;
        this.salesEmpId = salesEmpId;
        this.projectRequest = projectRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getSalesEmpId() {
        return salesEmpId;
    }

    public void setSalesEmpId(final int salesEmpId) {
        this.salesEmpId = salesEmpId;
    }

    public ProjectRequest getProjectRequest() {
        return projectRequest;
    }

    public void setProjectRequest(final ProjectRequest projectRequest) {
        this.projectRequest = projectRequest;
    }
}
