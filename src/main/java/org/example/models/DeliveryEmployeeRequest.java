package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private int deliveryEmployeeId;
    private int employeeId;

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public void setDeliveryEmployeeId(final int deliveryEmployeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }

    @JsonCreator DeliveryEmployeeRequest(
            @JsonProperty("DeliveryID") final int deliveryEmployeeId,
            @JsonProperty("EmployeeID") final int employeeId) {
                this.deliveryEmployeeId = deliveryEmployeeId;
                this.employeeId = employeeId;

    }
}
