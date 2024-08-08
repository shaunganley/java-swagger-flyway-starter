package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;


public final class DeliveryEmployeeValidator {

    private DeliveryEmployeeValidator() {
    }

    public static void validateDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws InvalidException {

        final int fifty = 50;

        if (deliveryEmployeeRequest.getName().length() > fifty) {
            throw new InvalidException(Entity.DELIVERY, "Name is too long");
        }
        if (deliveryEmployeeRequest.getSalary() < 0) {
            throw new InvalidException(Entity.DELIVERY, "Invalid Salary");
        }
        if (deliveryEmployeeRequest.getBankNumber().length() > fifty) {
            throw new InvalidException(Entity.DELIVERY,
                    "Bank Number is too long");
        }
        if (deliveryEmployeeRequest.getNationalInsurance().length() > fifty) {
            throw new InvalidException(Entity.DELIVERY,
                    "National Insurance Number is too long");
        }

    }
}
