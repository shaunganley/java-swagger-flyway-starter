package org.example.daos;

import org.example.models.Employee;
import org.example.models.Sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllSalesEmloyees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try
                (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select empId, name,, salary,"
                            +
                            " bankAccNo, nino, commisionRate"
                            +
                            " from Employee "
                            +
                            "join salesEmployee "
                            +
                            "using (empId);");

            while (resultSet.next()) {

                Employee employee = new Employee(
                        resultSet.getInt("empId"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bankAccNo"),
                        resultSet.getString("nino"),
                new Sales(resultSet.getDouble("commissionRate")));

                employees.add(employee);
            }
        }
        return employees;
    }

}
