package org.example.services;

import org.example.daos.SalesEmployeeDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.SalesEmployeeRequest;

import java.sql.SQLException;

public class SalesEmployeeService {
    SalesEmployeeDao salesEmployeeDao;

    public SalesEmployeeService(SalesEmployeeDao salesEmployeeDao) {
        this.salesEmployeeDao = salesEmployeeDao;
    }

    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) throws SQLException, FailedToCreateException {
        int id = salesEmployeeDao.createSalesEmployee(salesEmployeeRequest);
        if (id == -1) {
            throw new FailedToCreateException(Entity.SALES_EMPLOYEE);
        }
        return id;
    }
}
