package org.example.models;

import java.math.BigDecimal;

public class DeliveryEmployee extends Employee {

    public DeliveryEmployee(final int id, final String name,
                            final BigDecimal salary,
                            final String bankAccountNumber, final String nin) {
        super(id, name, salary, bankAccountNumber, nin);
    }
}
