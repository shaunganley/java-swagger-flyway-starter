package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DeliveryEmployeeRequest {
    private int deliveryEmployeeId;
    private int employeeId;

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public void setDeliveryEmployeeId(int deliveryEmployeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
    }

    public int getEmployee() {
        return employeeId;
    }

    public void setEmployee(int employeeId) {
        this.employeeId = employeeId;
    }

    @JsonCreator DeliveryEmployeeRequest(
            @JsonProperty("DeliveryID") int deliveryEmployeeId,
            @JsonProperty("EmployeeID") int employeeId){
                this.deliveryEmployeeId = deliveryEmployeeId;
                this.employeeId = employeeId;

    }
}
