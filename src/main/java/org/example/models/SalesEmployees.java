package org.example.models;

import java.math.BigDecimal;

public class SalesEmployees extends Employees {

    private float commission;

    public SalesEmployees(final int id, final String name,
                         final BigDecimal salary,
                         final String bankAccountNumber,
                         final String nin, final float commission) {
        super(id, name, salary, bankAccountNumber, nin);
        this.commission = commission;
    }
    public float getCommission() {
        return commission;
    }
    public void setCommission(final float commission) {
        this.commission = commission;
    }
}
