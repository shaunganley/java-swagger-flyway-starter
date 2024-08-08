package org.example.models;

import java.math.BigDecimal;

public class SalesEmployeeResponse {
    private int salesEmployeeId;
    private int employeeId;
    private BigDecimal commissionRate;

    public SalesEmployeeResponse (final int salesEmployeeId, final int employeeId,
                                  final BigDecimal commissionRate) {
        this.salesEmployeeId = salesEmployeeId;
        this.employeeId = employeeId;
        this.commissionRate = commissionRate;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }
}
