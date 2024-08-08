package org.example.models;

import java.math.BigDecimal;

public class SalesEmployee {
    private int salesEmployeeId;
    private BigDecimal commissionRate;
    private Employee employee;

    public SalesEmployee(int salesEmployeeId, BigDecimal commissionRate, Employee employee) {
        this.salesEmployeeId = salesEmployeeId;
        this.commissionRate = commissionRate;
        this.employee = employee;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

