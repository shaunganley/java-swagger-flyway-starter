package org.example.daos;

import org.example.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllDeliveryEmloyees() throws SQLException {
        List<Employee> orders = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select * from Employee join deliveryEmployee using (empId);");

            while (resultSet.next()) {

//                Order order = new Order(
//                        resultSet.getInt("OrderID"),
//                        new Customer(resultSet.getInt("CustomerID"), resultSet.getString("CustomerName")),
//                        resultSet.getDate("OrderDate"));
//
//                Employees.add(order);
            }
        }
        return Employees;
    }

    public List<Employee> getAllSalesEmloyees() throws SQLException {
        List<Employee> orders = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select * from Employee join salesEmployee using (empId);");

            while (resultSet.next()) {

//                Order order = new Order(
//                        resultSet.getInt("OrderID"),
//                        new Customer(resultSet.getInt("CustomerID"), resultSet.getString("CustomerName")),
//                        resultSet.getDate("OrderDate"));
//
//                Employees.add(order);
            }
        }
        return Employees;
    }

}
