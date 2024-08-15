package org.example.daos;

import org.example.models.SalesEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

        public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
            List<SalesEmployee> salesEmployees = new ArrayList<>();

            try (Connection connection = DatabaseConnector.getConnection()) {
                String query =
                        "SELECT employee.id, name, salary,"
                                +
                                "bankNumber, nationalInsurance,commissionRate"
                                +
                                " from employee"
                                +
                                " join sales"
                                +
                                " on employee.id = sales.employeeID;";
                PreparedStatement statement =
                        connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    salesEmployees.add(new SalesEmployee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getBigDecimal("salary"),
                            resultSet.getString("bankNumber"),
                            resultSet.getString("nationalInsurance"),
                            resultSet.getFloat("commissionRate")));
                }
            }
            return salesEmployees;
        }
    }

