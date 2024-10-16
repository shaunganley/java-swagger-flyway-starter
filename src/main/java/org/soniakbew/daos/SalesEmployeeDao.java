package org.soniakbew.daos;
import org.soniakbew.models.SalesEmployee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDao {
        public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
            List<SalesEmployee> salesEmployees = new ArrayList<>();

            try (Connection connection = DatabaseConnector.getConnection()) {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM salesEmployees INNER JOIN project;");

                while (resultSet.next()) {
                    SalesEmployee salesEmployee = new SalesEmployee(
                            resultSet.getInt("salesEmployeeID"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("bankAccountNumber"),
                            resultSet.getString("nationalInsuranceNumber"),
                            resultSet.getFloat("comissionRate")
                    );
                    salesEmployees.add(salesEmployee);
                }
            }
            return salesEmployees;
        }

        public void createSalesEmployee(salesEmployeeRequest salesEmployeeRequest) throws SQLException{
                Connection c = DatabaseConnector.getConnection();
                String insertStatement = "INSERT INTO salesEmployee(salesEmployeeID,firstName,lastName,salary,bankAccountNumber"
                        + "nationalInsuranceNumber,comissionRate) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
                st.setInt(1, salesEmployeeRequest.getCustomerID());
                st.setDate(2,Order.getOrderDate());
                st.setDate(3, Order.getDispatchDate());
                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    return rs.getInt(1);
                }

                return -1;
        }
        public void updateSalesEmployeeRequest(int id, SalesEmployeeRequest salesEmployeeRequest) throws SQLException{
            Connection c = DatabaseConnector.getConnection();
            String updateStatement = "UPDATE salesEmployee SET salesEmployeeID =?, fistName = ?, lastName = ? "
                    + ",salary =?, bankAccountNumber =?, WHERE OrderID = ?";
            PreparedStatement st = c.prepareStatement(updateStatement);
            st.setInt(1,Order.getCustomerID());
            st.setDate(2, Order.getOrderDate());
            st.setDate(3,Order.getDispatchDate());
            st.setInt(4,id);
        }

    public void deleteSalesEmployee(final int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        String deleteStatement = "DELETE FROM salesEmployee WHERE salesEmployeeID = ?";
        PreparedStatement st = c.prepareStatement(deleteStatement);
        st.setInt(1, id);
        st.executeUpdate();
    }
}
