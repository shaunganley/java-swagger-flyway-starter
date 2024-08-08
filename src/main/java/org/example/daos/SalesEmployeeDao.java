package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;
import org.example.models.SalesEmployee;
import org.example.models.SalesEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesEmployeeDao {

    public static SalesEmployee getSalesEmployeeById(final int id) throws SQLException {

        try (Connection connection = DatabaseConnector.getConnection()) {
        String query =
                "select employee.id as 'Employee Id', name, salary, bankNumber, "
                        + "nationalInsurance, sales.commissionRate from employee "
                        + "right join sales on employee.id = sales.employeeID;";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                    resultSet.getInt("delivery.id"),
                    resultSet.getString("Name"),
                    resultSet.getDouble("salary"),
                    resultSet.getString("bankNumber"),
                    resultSet.getString("nationalInsurance"));
        }
    }

        return null;
    }

    public static void updateSalesEmployee(int id,
                               SalesEmployeeRequest salesEmployee) throws
            SQLException {

        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE employee SET name = ?, "
                + "salary = ?, bankNumber = ?, nationalInsurance = ?, "
                + "sales.commisionRate = ? WHERE id = (SELECT employeeID "
                + "FROM sales WHERE id = ?);";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, salesEmployee.getName());
        st.setDouble(2, salesEmployee.getSalary());
        st.setString(3, salesEmployee.getBankNumber());
        st.setString(4, salesEmployee.getNationalInsurance());
        st.setDouble(5, salesEmployee.getCommissionRate());

        st.executeUpdate();
    }
}
