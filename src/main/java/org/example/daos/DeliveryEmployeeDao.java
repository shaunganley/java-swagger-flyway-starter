package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryEmployeeDao {

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
