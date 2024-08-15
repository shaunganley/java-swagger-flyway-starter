package org.example.daos;

import org.example.models.SalesEmployees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

        public List<SalesEmployees> getAllSalesEmployees() throws SQLException {
            List<SalesEmployees> salesEmployees = new ArrayList<>();

            try (Connection connection = DatabaseConnector.getConnection()) {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT id, name, salary, bankNo, nin, "
                                + "commissionRate from Employee "
                                + "join SalesEmployee USING(id)");

                while (resultSet.next()) {
                    salesEmployees.add(new SalesEmployees(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getBigDecimal("salary"),
                            resultSet.getString("bankNo"),
                            resultSet.getString("nin"),
                            resultSet.getFloat("commissionRate")));
                }
            }
            return salesEmployees;
        }
    }

