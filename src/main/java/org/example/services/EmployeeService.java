package org.example.services;


import org.example.daos.EmployeeDao;
import org.example.models.DeliveryEmployee;
import org.example.models.SalesEmployee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(final EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        return employeeDao.getAllSalesEmployees();
    }

    public List<DeliveryEmployee> getAllDeliveryEmployees()throws SQLException {
        return employeeDao.getAllDeliveryEmployees();
    }
}
