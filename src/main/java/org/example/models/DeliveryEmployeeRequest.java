package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private final int deliveryEmployeeId;
    private final int employeeId;

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public int getEmployee() {
        return employeeId;
    }

    @JsonCreator DeliveryEmployeeRequest(
            @JsonProperty("DeliveryID") final int deliveryEmployeeId,
            @JsonProperty("EmployeeID") final int employeeId){
                this.deliveryEmployeeId = deliveryEmployeeId;
                this.employeeId = employeeId;

    }
}
