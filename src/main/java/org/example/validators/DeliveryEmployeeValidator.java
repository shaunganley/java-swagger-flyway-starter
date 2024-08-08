package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.SQLException;

public class DeliveryEmployeeValidator {

    public static void validateDeliveryEmployee(
            DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws InvalidException {

        if (deliveryEmployeeRequest.getName().length()>50){
            throw new InvalidException(Entity.DELIVERY, "Name is too long");
        }
        if (deliveryEmployeeRequest.getSalary() < 0){
            throw new InvalidException(Entity.DELIVERY, "Invalid Salary");
        }
        if (deliveryEmployeeRequest.getBankNumber().length()>50){
            throw new InvalidException(Entity.DELIVERY, "Bank Number is too long");
        }
        if (deliveryEmployeeRequest.getNationalInsurance().length()>50){
            throw new InvalidException(Entity.DELIVERY, "National Insurance Number is too long");
        }

    }
}
