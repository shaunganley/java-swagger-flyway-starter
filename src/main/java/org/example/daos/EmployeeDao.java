package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeDetailsRequest;
import org.example.models.SalesEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    final int stIntMaxThree = 3;
    final int stIntMaxFour = 4;

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
            String query = "SELECT employee.id, name, salary,"
                    +
                    "bankNumber, nationalInsurance,commissionRate "
                    +
                    "from employee "
                    +
                    "right join sales "
                    +
                    "on employee.id = sales.employeeID "
                    +
                    "where sales.id = ?;";
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

    public DeliveryEmployee getDeliveryEmployeeById(final int id)

            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT employee.id, name, salary,"
                    +
                    "bankNumber, nationalInsurance "
                    +
                    "from employee "
                    +
                    "right join delivery "
                    +
                    "on employee.id = delivery.employeeID "
                    +
                    "where delivery.id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new DeliveryEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("bankNumber"),
                        resultSet.getString("nationalInsurance"));
            }
        }
        return null;
    }

    public int createDeliveryEmployee(
            final DeliveryEmployeeDetailsRequest
                    deliveryEmployeeDetailsRequest)
        throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        String insertStatement1 = "insert into employee "
                +
                "(name, salary, bankNumber, nationalInsurance)"
                +
                " Values (?, ?, ?, ?);";
        String insertStatement2 = "insert into delivery(employeeID)"
                +
                " Select MAX(id) from employee;";
        PreparedStatement statement =
                connection.prepareStatement(insertStatement1,
                Statement.RETURN_GENERATED_KEYS);
        PreparedStatement statement2 =
                connection.prepareStatement(insertStatement2,
                        Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, deliveryEmployeeDetailsRequest.getName());
        statement.setBigDecimal(2, deliveryEmployeeDetailsRequest.getSalary());
        statement.setString(stIntMaxThree,
                deliveryEmployeeDetailsRequest.getBankAccountNumber());
        statement.setString(stIntMaxFour,
                deliveryEmployeeDetailsRequest.getNin());
        statement.executeUpdate();
        statement2.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return -1;
    }
}
