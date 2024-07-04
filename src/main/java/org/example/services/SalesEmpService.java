package org.example.services;

import org.example.daos.SalesEmpDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.SalesEmpRequest;

import java.sql.SQLException;

public class SalesEmpService {
    SalesEmpDao salesEmpDao;

    public SalesEmpService(SalesEmpDao salesEmpDao) {
        this.salesEmpDao = salesEmpDao;
    }

    public int createSalesEmployee(SalesEmpRequest salesEmpRequest) throws SQLException, FailedToCreateException {
        int id = salesEmpDao.createSalesEmployee(salesEmpRequest);
        if (id == -1) {
            throw new FailedToCreateException(Entity.SALES_EMPLOYEE);
        }
        return id;
    }
}
