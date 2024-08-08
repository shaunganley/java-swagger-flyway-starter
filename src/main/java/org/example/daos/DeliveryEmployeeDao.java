package org.example.daos;

import org.example.models.DeliveryEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {

    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `DeliveryEmployees`;");

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("bank_acc"),
                        resultSet.getString("ni")
                );
                deliveryEmployees.add(deliveryEmployee);
            }
        }

        return deliveryEmployees;
    }
}
