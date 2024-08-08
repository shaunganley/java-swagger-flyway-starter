package org.example.daos;

import org.example.models.DeliveryEmployeeRequest;
import org.example.models.SalesEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesEmployeeDao {

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
