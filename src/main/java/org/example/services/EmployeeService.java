package org.example.services;

import org.example.controllers.EmployeeController;
import org.example.models.Employee;
import org.example.daos.EmployeeDao;
import org.example.models.EmployeeRequest;
import org.example.models.SalesEmployee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAllEmployees();
    }

    public List<SalesEmployee> getSalesEmployees() throws SQLException {
        return employeeDao.getAllSalesEmployee();
    }

    public Employee getEmployeeById(int id) throws SQLException {
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmployee(int id, EmployeeRequest employeeRequest)
            throws SQLException {
        Employee employeeToUpdate = employeeDao.getEmployeeById(id);
    }

    public int createEmployee(EmployeeRequest employeeRequest) throws SQLException {
        int id = employeeDao.createEmployee(employeeRequest);

        return id;
    }



}
