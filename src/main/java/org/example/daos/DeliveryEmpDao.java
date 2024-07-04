package org.example.daos;

import org.example.models.DeliveryEmpRequest;

import java.sql.*;

public class DeliveryEmpDao {
    public int createSalesEmployee(DeliveryEmpRequest deliveryEmpRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String insertStatement = "INSERT INTO `SalesEmployee`(Name, BankAcctNum, NINO, Salary)" +
                    "VALUES (?, ?, ?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, deliveryEmpRequest.getName());
            statement.setInt(2, deliveryEmpRequest.getBankAccountNo());
            statement.setString(3, deliveryEmpRequest.getNationalInsurance());
            statement.setDouble(4, deliveryEmpRequest.getSalary());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
}