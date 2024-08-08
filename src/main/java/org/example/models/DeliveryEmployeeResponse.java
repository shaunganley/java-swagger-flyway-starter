package org.example.models;

public class DeliveryEmployeeResponse {
    private int deliveryEmployeeId;
    private int employeeId;

    public DeliveryEmployeeResponse(final int deliveryEmployeeId,
                                    final int employeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
        this.employeeId = employeeId;
    }

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public void setDeliveryEmployeeId(int deliveryEmployeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
