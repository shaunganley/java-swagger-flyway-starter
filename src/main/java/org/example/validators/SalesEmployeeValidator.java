package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;


public final class SalesEmployeeValidator {
    private SalesEmployeeValidator() {
    }
    public static void validateSalesEmployee(
            final SalesEmployeeRequest salesEmployeeRequest)
            throws InvalidException {

        final int fifty = 50;

        if (salesEmployeeRequest.getName().length() > fifty) {
            throw new InvalidException(Entity.SALES, "Name is too long");
        }
        if (salesEmployeeRequest.getSalary() < 0) {
            throw new InvalidException(Entity.SALES, "Invalid Salary");
        }
        if (salesEmployeeRequest.getBankNumber().length() > fifty) {
            throw new InvalidException(Entity.SALES, "Bank Number is too long");
        }
        if (salesEmployeeRequest.getNationalInsurance().length() > fifty) {
            throw new InvalidException(Entity.SALES,
                    "National Insurance Number is too long");
        }
        if (salesEmployeeRequest.getCommissionRate() < 0) {
            throw new InvalidException(Entity.SALES, "Invalid CommissionRate");
        }
    }
}
