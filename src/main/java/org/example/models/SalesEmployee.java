package org.example.models;

import java.math.BigDecimal;

public class SalesEmployee {
    private int salesEmployeeId;
    private BigDecimal commissionRate;
    private Employee employee;

    public SalesEmployee(final int salesEmployeeId,
                         final BigDecimal commissionRate,
                         final Employee employee) {
        this.salesEmployeeId = salesEmployeeId;
        this.commissionRate = commissionRate;
        this.employee = employee;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(final int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
}

