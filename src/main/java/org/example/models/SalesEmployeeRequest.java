package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SalesEmployeeRequest {
    private final int salesEmployeeId;
    private final int employeeId;
    private final BigDecimal commissionRate;

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    @JsonCreator SalesEmployeeRequest(
            @JsonProperty("SalesID") int salesEmployeeId,
            @JsonProperty("EmployeeID") int employeeId,
            @JsonProperty("Commission") BigDecimal commissionRate){
                this.salesEmployeeId = salesEmployeeId;
                this.employeeId = employeeId;
                this.commissionRate = commissionRate;
    }
}
