package org.example.models;

public class DeliveryProject {
    private int deliveryID;
    private int projectID;

    public DeliveryProject(final int deliveryID,
                           final int projectID, final Project project) {
        this.deliveryID = deliveryID;
        this.projectID = projectID;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(final int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(final int projectID) {
        this.projectID = projectID;
    }
}
