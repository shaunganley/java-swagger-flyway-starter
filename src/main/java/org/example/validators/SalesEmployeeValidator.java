package org.example.validators;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;

public class SalesEmployeeValidator {

    public void validateSalesEmployee(
            final SalesEmployeeRequest salesEmployeeRequest)
        throws InvalidException {
        final int maximumCommissionRate = 1;
        final int maximumNameLength = 50;
        final int maximumBankAccountNumberLength = 34;
        final int maximumNationalInsuranceNumberLength = 9;
        final int maximumSalaryLength = 15;
        if (salesEmployeeRequest.getCommissionRate()
                >= maximumCommissionRate) {
            throw new InvalidException(
                    Entity.SALESEMPLOYEE,
                    "Commission must not be greater than one"
            );
        }
        if (salesEmployeeRequest.getFirstName()
                .length() > maximumNameLength) {
            throw new InvalidException(
                    Entity.SALESEMPLOYEE,
                    "First name cannot be greater"
                    + " than 50 characters"
            );
        }
        if (salesEmployeeRequest.getLastName()
                .length() > maximumNameLength) {
            throw new InvalidException(
                    Entity.SALESEMPLOYEE,
                    "Last name cannot be greater"
                    + " than 50 characters");
        }
        if (salesEmployeeRequest.getBankAccountNumber()
                .length()
                > maximumBankAccountNumberLength) {
            throw new InvalidException(
                    Entity.SALESEMPLOYEE,
                    "Bank Account Number cannot be greater"
                    + " than 34 characters");
        }
        if (salesEmployeeRequest.getNationalInsuranceNumber()
                .length()
                > maximumNationalInsuranceNumberLength) {
            throw new InvalidException(
                    Entity.SALESEMPLOYEE,
                    "National Insurance Number"
                    + " cannot be greater"
                    + " than 9 characters");
        }
        if (Double.toString(salesEmployeeRequest.getSalary())
                .length() > maximumSalaryLength) {
                throw new InvalidException(
                        Entity.SALESEMPLOYEE,
                        "Salary cannot be greater than 15 digits long"
                );
        }
    }
}
