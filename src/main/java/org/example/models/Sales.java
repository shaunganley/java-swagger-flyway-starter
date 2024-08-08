package org.example.models;

public class Sales {

    private int salesEmpId;
    private double commissionRate;

    public Sales(int salesEmpId, double commissionRate) {
        this.salesEmpId = salesEmpId;
        this.commissionRate = commissionRate;
    }

    public int getSalesEmployeeID() {
        return salesEmpId;
    }

    public void setSalesEmployeeID (int salesEmpId) {
        this.salesEmpId = salesEmpId;
    }

    public double getComissionRate() {
        return commissionRate;
    }

    public void setComissionRate (double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
