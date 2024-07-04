package org.example.daos;

import org.example.models.SalesEmpRequest;

import java.sql.*;

public class SalesEmpDao {
    public int createSalesEmployee(SalesEmpRequest salesEmpRequest) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String insertStatement = "INSERT INTO `SalesEmployee`(Name, BankAcctNum, NINO, Salary, CommissionRate)" +
                    "VALUES (?, ?, ?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, salesEmpRequest.getName());
            statement.setInt(2, salesEmpRequest.getBankAccountNo());
            statement.setString(3, salesEmpRequest.getNationalInsurance());
            statement.setDouble(4, salesEmpRequest.getSalary());
            statement.setDouble(5, salesEmpRequest.getCommissionRate());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
}
