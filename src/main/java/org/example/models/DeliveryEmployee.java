package org.example.models;

public class DeliveryEmployee {
    private final int deliveryEmployeeId;
    private final Employee employee;

    public DeliveryEmployee(final int deliveryEmployeeId,
                            final Employee employee) {
        this.deliveryEmployeeId = deliveryEmployeeId;
        this.employee = employee;
    }

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public Employee getEmployee() {
        return employee;
    }
}
