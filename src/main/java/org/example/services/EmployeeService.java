package org.example.services;

import org.example.controllers.EmployeeController;
import org.example.models.Employee;
import org.example.daos.EmployeeDao;

import java.sql.SQLException;

public class EmployeeService {
    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(int id) throws SQLException {
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmployee(int id, EmployeeRequest employeeRequest)
            throws SQLException {
        Employee employeeToUpdate = employeeDao.getEmployeeById(id);
    }




}
