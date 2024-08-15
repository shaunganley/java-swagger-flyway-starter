package org.example.daos;

import org.example.models.DeliveryEmployee;
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

    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            String query =
                    "SELECT employee.id, name, "
                            +
                            "salary,bankNumber, nationalInsurance "
                            +
                            "from employee "
                            +
                            "join delivery "
                            +
                            "on employee.id = delivery.employeeID;";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                deliveryEmployees.add(new DeliveryEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("bankNumber"),
                        resultSet.getString("nationalInsurance")));
            }
        }
        return deliveryEmployees;
    }
    public SalesEmployee getSalesEmployeeById(final int id)

            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT employee.id, name, salary,bankNumber,"
                    +
                    " nationalInsurance,commissionRate "
                    +
                    "from employee "
                    +
                    "join sales "
                    +
                    "on employee.id = "
                    +
                    "sales.employeeID "
                    +
                    "where employee.id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new SalesEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("bankNumber"),
                        resultSet.getString("nationalInsurance"),
                        resultSet.getFloat("commissionRate"));
            }
        }
        return null;
    }
}
