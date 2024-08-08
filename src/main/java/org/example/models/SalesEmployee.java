package org.example.models;

import java.math.BigDecimal;

public class SalesEmployee {
    private final int salesEmployeeId;
    private final BigDecimal commissionRate;
    private final Employee employee;

    public SalesEmployee(final int salesEmployeeId,
                         final BigDecimal commissionRate, final Employee employee) {
        this.salesEmployeeId = salesEmployeeId;
        this.commissionRate = commissionRate;
        this.employee = employee;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public Employee getEmployee() {
        return employee;
    }
}

