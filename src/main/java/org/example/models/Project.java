package org.example.models;

import java.math.BigDecimal;

public class Project {
    private int projectId;
    private String projectName;
    private int value;
    private boolean isCompleted;
    private Client client;
    private DeliveryEmployee deliveryEmployee;

    public Project(int projectId, String projectName, int value, Client client, DeliveryEmployee deliveryEmployee) {
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DeliveryEmployee getDeliveryEmployee() {
        return deliveryEmployee;
    }

    public void setDeliveryEmployee(DeliveryEmployee deliveryEmployee) {
        this.deliveryEmployee = deliveryEmployee;
    }
}
