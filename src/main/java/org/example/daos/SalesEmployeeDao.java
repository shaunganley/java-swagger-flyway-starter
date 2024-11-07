package org.example.daos;

import org.example.models.SalesEmployee;
import org.example.models.SalesEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDao {
    final int parameterOne = 1;
    final int parameterTwo = 2;
    final int parameterThree = 3;
    final int parameterFour = 4;
    final int parameterFive = 5;
    final int parameterSix = 6;
    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        List<SalesEmployee> salesEmployees = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT Employee.employeeId, firstName, lastName, salary, "
                            + "bankAccountNumber, nationalInsuranceNumber, "
                            + "commissionRate FROM Employee INNER JOIN "
                            + "SalesEmployee ON Employee.employeeId = "
                            + "SalesEmployee.employeeId");

            while (resultSet.next()) {
                SalesEmployee salesEmployee = new SalesEmployee(
                        resultSet.getInt("Employee.employeeId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bankAccountNumber"),
                        resultSet.getString("nationalInsuranceNumber"),
                        resultSet.getDouble("commissionRate")
                );

                salesEmployees.add(salesEmployee);
            }
        }
        return salesEmployees;
    }
    public SalesEmployee getSalesEmployeeById(final int id)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            final String query =
                    ("SELECT Employee.employeeId, firstName, lastName, salary, "
                    + "bankAccountNumber, nationalInsuranceNumber, "
                    + "commissionRate FROM Employee INNER JOIN "
                    + "SalesEmployee ON Employee.employeeId = "
                    + "SalesEmployee.employeeId "
                    + "WHERE SalesEmployee.employeeId = ?");
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new SalesEmployee(
                        resultSet.getInt("Employee.employeeId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bankAccountNumber"),
                        resultSet.getString("nationalInsuranceNumber"),
                        resultSet.getDouble("commissionRate")
                );

            }
        }
        return null;
    }
    public int createSalesEmployee(final SalesEmployeeRequest
                                           salesEmployee) throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        String insertStatement = "INSERT INTO Employee(firstName, lastName, "
                + "salary, bankAccountNumber, nationalInsuranceNumber)"
                + " VALUES(?,?,?,?,?);";
        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);
        st.setString(parameterOne, salesEmployee.getFirstName());
        st.setString(parameterTwo, salesEmployee.getLastName());
        st.setDouble(parameterThree, salesEmployee.getSalary());
        st.setString(parameterFour, salesEmployee.getBankAccountNumber());
        st.setString(parameterFive,
                salesEmployee.getNationalInsuranceNumber());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            int employeeId = rs.getInt(1);

            insertStatement = "INSERT INTO SalesEmployee(employeeId, "
                    + "CommissionRate) VALUES(?,?)";

            PreparedStatement st2 = c.prepareStatement(insertStatement);
            st2.setInt(parameterOne, employeeId);
            st2.setDouble(parameterTwo, salesEmployee.getCommissionRate());
            int rowsUpdated = st2.executeUpdate();

            if (rowsUpdated == 1) {
                return employeeId;
            }
        }

        return -1;
    }
    public void updateSalesEmployee(final int id,
                                    final SalesEmployeeRequest salesEmployee)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        String updateStatement = "UPDATE Employee SET firstName=?,"
                + "lastName=?,salary=?,"
                + "bankAccountNumber=?,nationalInsuranceNumber=?"
                + "WHERE employeeId = ?;";
        PreparedStatement st = c.prepareStatement(updateStatement);
        st.setString(parameterOne, salesEmployee.getFirstName());
        st.setString(parameterTwo, salesEmployee.getLastName());
        st.setDouble(parameterThree, salesEmployee.getSalary());
        st.setString(parameterFour, salesEmployee.getBankAccountNumber());
        st.setString(parameterFive, salesEmployee.getNationalInsuranceNumber());
        st.setInt(parameterSix, id);
        st.executeUpdate();
        updateStatement = "UPDATE SalesEmployee"
                + " SET commissionRate=?"
                + " WHERE employeeId = ?;";
        PreparedStatement st2 = c.prepareStatement(updateStatement);
         st2.setDouble(parameterOne, salesEmployee.getCommissionRate());
         st2.setInt(parameterTwo, id);
         st2.executeUpdate();
    }
    public void deleteProduct(final int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        String deleteStatement = "DELETE FROM "
                + "SalesEmployee WHERE EmployeeId = ?";
        PreparedStatement st = c.prepareStatement(deleteStatement);
        st.setInt(parameterOne, id);
        st.executeUpdate();
        deleteStatement = "DELETE FROM "
                + "Employee WHERE EmployeeId = ?";
        PreparedStatement st2 = c.prepareStatement(deleteStatement);
        st2.setInt(parameterOne, id);
        st2.executeUpdate();
    }

}
