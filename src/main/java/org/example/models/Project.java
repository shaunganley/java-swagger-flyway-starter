package org.example.models;

import java.math.BigDecimal;

public class Project {
    private final int projectId;
    private final String projectName;
    private final int value;
    private final boolean isCompleted;
    private final Client client;
    private final DeliveryEmployee deliveryEmployee;

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

    public String getProjectName() {
        return projectName;
    }

    public int getValue() {
        return value;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Client getClient() {
        return client;
    }

    public DeliveryEmployee getDeliveryEmployee() {
        return deliveryEmployee;
    }
}
