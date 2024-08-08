package org.example.daos;

import org.example.models.SalesEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDao {

    public List<SalesEmployee> getAllSalesEmployees()
            throws SQLException {
        List<SalesEmployee> salesEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `SalesEmployees`;");

            while (resultSet.next()) {
                SalesEmployee salesEmployee = new SalesEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("bank_acc"),
                        resultSet.getString("ni"),
                        resultSet.getDouble("commissionRate")
                );
                salesEmployees.add(salesEmployee);
            }
        }

        return salesEmployees;
    }

}
