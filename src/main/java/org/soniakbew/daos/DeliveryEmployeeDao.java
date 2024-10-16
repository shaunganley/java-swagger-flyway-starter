package org.soniakbew.daos;

import org.soniakbew.models.DeliveryEmployee;
import org.soniakbew.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                    "SELECT deliveryEmployeeId, `name`, salary, bankAccountNumber, nationalInsuranceNumber FROM deliveryEmployee;"
            );

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("deliveryEmployeeID"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bankAccountNumber"),
                        resultSet.getString("nationalInsuranceNumber")
                );

                deliveryEmployees.add(deliveryEmployee);
            }

        }

        return deliveryEmployees;
    }


    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO deliveryEmployee (deliveryEmployeeId, `name`, salary, bankAccountNumber, nationalInsuranceNumber) VALUES (?,?,?,?,?);";

        PreparedStatement pst = conn.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, DeliveryEmployeeRequest.getCustomerId());
        pst.setDate(2, order.getOrderDate());

        pst.executeUpdate();

        ResultSet res = pst.getGeneratedKeys();
        if (res.next()) {
            return res.getInt(1);
        }

        return -1;
    }

}


