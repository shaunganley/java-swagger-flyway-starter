package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;
import org.example.models.SalesEmployeeRequest;

import java.sql.SQLException;

public class SalesEmployeeValidator {

    public static void validateSalesEmployee(
            SalesEmployeeRequest salesEmployeeRequest)
            throws InvalidException {

        if (salesEmployeeRequest.getName().length()>50){
            throw new InvalidException(Entity.SALES, "Name is too long");
        }
        if (salesEmployeeRequest.getSalary() < 0){
            throw new InvalidException(Entity.SALES, "Invalid Salary");
        }
        if (salesEmployeeRequest.getBankNumber().length()>50){
            throw new InvalidException(Entity.SALES, "Bank Number is too long");
        }
        if (salesEmployeeRequest.getNationalInsurance().length()>50){
            throw new InvalidException(Entity.SALES, "National Insurance Number is too long");
        }
        if (salesEmployeeRequest.getCommissionRate() < 0){
            throw new InvalidException(Entity.SALES, "Invalid CommissionRate");
        }
    }
}
