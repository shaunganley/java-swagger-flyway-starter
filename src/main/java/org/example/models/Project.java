package org.example.models;

public class Project {
    private int projectId;
    private String projectName;
    private int value;
    private boolean isCompleted;
    private Client client;
    private DeliveryEmployee deliveryEmployee;

    public Project(final int projectId, final String projectName,
                   final int value, final Client client,
                   final DeliveryEmployee deliveryEmployee) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.value = value;
        this.isCompleted = false;
        this.client = client;
        this.deliveryEmployee = deliveryEmployee;
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

    public void setIsCompleted(final boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public DeliveryEmployee getDeliveryEmployee() {
        return deliveryEmployee;
    }

    public void setDeliveryEmployee(final DeliveryEmployee deliveryEmployee) {
        this.deliveryEmployee = deliveryEmployee;
    }
}
