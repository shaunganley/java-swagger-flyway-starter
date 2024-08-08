package org.example.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDao {

    public int createCompletedProject(
            final int projectId, final int deliveryId) throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "DELIMITER // \n"
                + "create trigger Trigger2 after delete on project "
                + "FOR  EACH  ROW\n"
                + "BEGIN INSERT INTO `completedProject` (clientId, techLead) "
                + "VALUES (?,?); END// \n"
                + "DELIMITER ;";

        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, projectId);
        st.setInt(2, deliveryId);

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);

        }

        return -1;
    }

}
