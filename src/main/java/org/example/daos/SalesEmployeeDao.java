package org.example.daos;

import org.example.models.SalesEmployeeRequest;

import java.sql.*;

public class SalesEmployeeDao {
    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection()) {

            String insertStatement = "INSERT INTO `SalesEmployee`(Name, BankAcctNum, NINO, Salary, CommissionRate)" +
                    "VALUES (?, ?, ?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, salesEmployeeRequest.getName());
            statement.setInt(2, salesEmployeeRequest.getBankAccountNo());
            statement.setString(3, salesEmployeeRequest.getNationalInsurance());
            statement.setDouble(4, salesEmployeeRequest.getSalary());
            statement.setDouble(5, salesEmployeeRequest.getCommissionRate());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
}
