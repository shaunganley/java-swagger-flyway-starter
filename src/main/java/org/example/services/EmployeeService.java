package org.example.services;


import org.example.daos.EmployeeDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
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

    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        return employeeDao.getAllDeliveryEmployees();
    }

    public SalesEmployee getSalesEmployeeById(final int id)
            throws SQLException, DoesNotExistException {
        SalesEmployee salesEmployee = employeeDao.getSalesEmployeeById(id);
        if (salesEmployee == null) {
            throw new DoesNotExistException(Entity.SALESEMPLOYEE);
        }
        return salesEmployee;
    }

    public DeliveryEmployee getDeliveryEmployeeById(final int id)
            throws SQLException, DoesNotExistException {
        DeliveryEmployee deliveryEmployee = employeeDao.getDeliveryEmployeeById(id);
        if (deliveryEmployee == null) {
            throw new DoesNotExistException(Entity.SALESEMPLOYEE);
        }
        return deliveryEmployee;
    }
}
