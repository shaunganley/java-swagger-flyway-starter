package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.EmployeeRequest;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeValidator {

    EmployeeRequest employeeRequest;

    public EmployeeValidator(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }

    public  void validateEmployee(EmployeeRequest employeeRequest) throws InvalidException,
            SQLException {

        int BankAccountNumberLength = employeeRequest.getBankAccountNumber().length();
        if(BankAccountNumberLength != 11 ){
            throw new InvalidException(Entity.EMPLOYEE, "Invalid Bank Account Number");
        }

    }
}
