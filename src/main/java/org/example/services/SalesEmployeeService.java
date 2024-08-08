package org.example.services;

import org.example.daos.SalesEmployeeDao;
import org.example.models.SalesEmployee;

import java.sql.SQLException;
import java.util.List;

public class SalesEmployeeService {

    SalesEmployeeDao salesEmployeeDao;

    public SalesEmployeeService(
            final SalesEmployeeDao salesEmployeeDao) {
        this.salesEmployeeDao = salesEmployeeDao;
    }

    public List<SalesEmployee> getAllSalesEmployees()
            throws SQLException {
        return salesEmployeeDao.getAllSalesEmployees();
    }

}
