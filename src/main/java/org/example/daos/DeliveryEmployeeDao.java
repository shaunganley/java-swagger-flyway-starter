package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryEmployeeDao {

    public static DeliveryEmployee getDeliveryEmployeeById(final int id) throws SQLException {

        try (Connection connection = DatabaseConnector.getConnection()) {
            String query =
                    "select employee.id as 'Employee Id', name, salary, "
                            + "bankNumber, nationalInsurance from employee "
                            + "right join delivery on employee.id = delivery.employeeID;";

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

    public static void updateDeliveryEmployee(int id,
                               DeliveryEmployeeRequest deliveryEmployee) throws
            SQLException {

        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE employee SET name = ?, "
                + "salary = ?, bankNumber = ?, nationalInsurance = ? "
                + "WHERE id = (SELECT employeeID FROM delivery WHERE id = ?);";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, deliveryEmployee.getName());
        st.setDouble(2, deliveryEmployee.getSalary());
        st.setString(3, deliveryEmployee.getBankNumber());
        st.setString(4, deliveryEmployee.getNationalInsurance());

        st.executeUpdate();
    }
}
