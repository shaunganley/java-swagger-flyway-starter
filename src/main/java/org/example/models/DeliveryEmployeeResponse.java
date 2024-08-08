package org.example.models;

public class DeliveryEmployeeResponse {
    private final int deliveryEmployeeId;
    private final int employeeId;

    public DeliveryEmployeeResponse(final int deliveryEmployeeId,
                                    final int employeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
        this.employeeId = employeeId;
    }

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
