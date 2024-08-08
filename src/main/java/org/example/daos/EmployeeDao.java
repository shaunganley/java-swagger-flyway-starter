package org.example.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    //get all employees
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT EmployeeID, Name, Salary,BankAccountNumber, NationalInsuranceNumber"
                            +
                            " FROM Employee ");

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("EmployeeID"),
                        resultSet.getString("Name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("BankAccountNumber"),
                        resultSet.getString("NationalInsuranceNumber"));


                employees.add(employee);
            }
        }

        return employees;
    }



    //create employee
    public int createEmployee(final EmployeeRequest employee)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO Employee (, Name, Salary, "
                        +
                        "BankAcountNumber,"
                        +
                        "NationalInsuranceNumber) VALUES (?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, employee.getEmployeeId());
        st.setString(1,employee.getEmployeeName);
        st.setBigDecimal(2, employee.getSalary());
        st.setString(1, employee.getBankAccountNumber());
        st.setString(1, employee.getNationalInsuranceNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);

        }
        return -1;

    }


    //create delivery emp
    public int createDeliveryEmployee(int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO DeliveryEmployee ( EmployeeID ) VALUES (?)";
        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, id);


        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);

        }
        return -1;

    }


    //create sales employee
    public int createSalesEmployee(int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO SalesEmployee ( EmployeeID ) VALUES (?)";
        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, id);


        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);

        }
        return -1;
    }





    //get all sales employees
    public List<SalesEmployee> getAllSalesEmployee() throws SQLException {
        List<SalesEmployee> salesEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT EmployeeID, SalesID, Name, Salary,BankAccountNumber, NationalInsuranceNumber, CommissionRate"
                            +
                            " FROM Employee "
                            +
                            "join SalesEmployee using (SalesEmployeeID);");

            while (resultSet.next()) {
                SalesEmployee salesEmployee = new SalesEmployee(
                        resultSet.getInt("SalesID"),
                        resultSet.getString("Name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("BankAccountNumber"),
                        resultSet.getString("NationalInsuranceNumber"),
                        resultSet.getBigDecimal("CommissionRate"));


                salesEmployees.add(salesEmployee);
            }
        }

        return salesEmployees;
    }

    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT EmployeeID, DeliveryID, Name, Salary,BankAccountNumber, NationalInsuranceNumber"
                            +
                            " FROM Employee "
                            +
                            "join DeliveryEmployee using (EmployeeID);");

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("DeliveryID"),
                        resultSet.getString("Name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getString("BankAccountNumber"),
                        resultSet.getString("NationalInsuranceNumber"));


                deliveryEmployees.add(deliveryEmployee);
            }
        }

        return deliveryEmployees;
    }


    public Employee getEmployeeById(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT EmployeeID, Name, Salary, BankAccountNumber, NationalInsuranceNumber FROM Employee WHERE EmployeeID = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new Employee(
                        resultSet.getInt("EmployeeID"),
                        resultSet.getString("Name"),
                        resultSet.getBigDecimal("Salary"),
                        resultSet.getString("BankAccountNumber"),
                        resultSet.getString("NationalInsuranceNumber")
                );
            }
        }
        return null;
    }

    public void updateEmployee(int id, EmployeeRequest employeeRequest)
            throws SQLException {
        Connection connection = DatabaseConnector.getConnection();

        String updateStatment = "UPDATE Employee SET Name = ?,Salary = ?, BankAccountNumber = ?, NationalInsuranceNumber = ? WHERE EmployeeID = ?";
        PreparedStatement st = connection.prepareStatement(updateStatment);

        updateStatment.setString(1, employeeRequest.getName());

    }

}
