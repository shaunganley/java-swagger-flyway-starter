package org.example.models;

import java.math.BigDecimal;

public class SalesEmployeeResponse {
    private final int salesEmployeeId;
    private final int employeeId;
    private final BigDecimal commissionRate;

    public SalesEmployeeResponse (final int salesEmployeeId, final int employeeId,
                                  final BigDecimal commissionRate) {
        this.salesEmployeeId = salesEmployeeId;
        this.employeeId = employeeId;
        this.commissionRate = commissionRate;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }
}
