package org.example.daos;

import org.example.models.SalesEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

        public List<SalesEmployees> getAllSalesEmployees() throws SQLException {
            List<SalesEmployees> salesEmployees = new ArrayList<>();

            try (Connection connection = DatabaseConnector.getConnection()) {
                String query =
                        "SELECT id, name, salary, "
                                +
                                "bankNumber, nationalInsurance, "
                        + "commissionRate from employee "
                        + "join sales USING(id);";
                PreparedStatement statement =
                        connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    salesEmployees.add(new SalesEmployees(
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

