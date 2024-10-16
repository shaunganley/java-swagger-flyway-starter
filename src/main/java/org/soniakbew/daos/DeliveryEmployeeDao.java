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

        String insertStatement = "INSERT INTO deliveryEmployee (`name`, salary, bankAccountNumber, nationalInsuranceNumber) VALUES (?,?,?,?);";

        PreparedStatement pst = conn.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, deliveryEmployee.getName());
        pst.setDouble(2, deliveryEmployee.getSalary());
        pst.setString(3, deliveryEmployee.getBankAccountNumber()),
        pst.setString(4, deliveryEmployee.getNationalInsuranceNumber());

        pst.executeUpdate();

        ResultSet res = pst.getGeneratedKeys();

        if (res.next()) {
            return res.getInt(1);
        }

        return -1;
    }

    public void updateDeliveryEmployee(int id, DeliveryEmployeeRequest deliveryEmployee) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();

        String statement = "UPDATE deliveryEmployee SET `name`=?, salary=?, bankAccountNumber=?, nationalInsuranceNumber=? WHERE ProductID = ?;";
        PreparedStatement pst = conn.prepareStatement(statement);

        pst.setString(1, deliveryEmployee.getName());
        pst.setDouble(2, deliveryEmployee.getSalary());
        pst.setString(3, deliveryEmployee.getBankAccountNumber());
        pst.setInt(4, id);

        pst.executeUpdate();
    }


}


