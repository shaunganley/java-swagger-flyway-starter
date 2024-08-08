package org.example.models;

public class Sales {

    private int salesEmpId;
    private double commissionRate;

    public Sales(final int salesEmpId, final double commissionRate) {
        this.salesEmpId = salesEmpId;
        this.commissionRate = commissionRate;
    }

    public Sales(final double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getSalesEmpId() {
        return salesEmpId;
    }

    public void setSalesEmpId(final int salesEmpId) {
        this.salesEmpId = salesEmpId;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
