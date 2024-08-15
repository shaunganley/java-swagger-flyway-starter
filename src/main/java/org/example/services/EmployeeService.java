package org.example.services;


import org.example.daos.EmployeeDao;
import org.example.models.SalesEmployees;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(final EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<SalesEmployees> getAllSalesEmployees() throws SQLException {
        return employeeDao.getAllSalesEmployees();
    }
}
