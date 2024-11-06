package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;

public class DeliveryEmployeeValidator {
    public void validateDeliveryEmployee(
            DeliveryEmployeeRequest deliveryEmployeeRequest) throws
            InvalidException {
        if (deliveryEmployeeRequest.getName().length() > 50) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE, "Name greater than 50 characters.");
        }

        if (deliveryEmployeeRequest.getSalary() < 18000 ) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE, "Salary must be above 18000 to meet the minimum wage.");
        }

        if (deliveryEmployeeRequest.getBankAccountNumber().length() > 34) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE, "Bank account number greater than 34 characters.");
        }

        if (deliveryEmployeeRequest.getNationalInsuranceNumber().length() < 9) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE, "National Insurance number greater than 9 characters.");
        }
    }
}
