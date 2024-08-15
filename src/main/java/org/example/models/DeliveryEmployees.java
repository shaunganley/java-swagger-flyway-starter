package org.example.models;

import java.math.BigDecimal;

public class DeliveryEmployees  extends Employees {

    public DeliveryEmployees(final int id, final String name,
                             final BigDecimal salary,
                             final String bankAccountNumber, final String nin) {
        super(id, name, salary, bankAccountNumber, nin);
    }
}
