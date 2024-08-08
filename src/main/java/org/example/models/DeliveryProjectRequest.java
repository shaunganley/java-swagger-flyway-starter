package org.example.models;

public class DeliveryProjectRequest {
    private int deliveryID;
    private int projectID;

    public DeliveryProjectRequest(final int deliveryID, final int projectID) {
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
