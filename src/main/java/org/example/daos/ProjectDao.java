package org.example.daos;

import org.example.models.Project;
import org.example.models.ProjectDetailsRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDao {
    final int stIntMaxThree = 3;
    final int stIntMaxFour = 4;

    public Project getHighestValueProject() throws SQLException {
        Project project = null;
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query =
                    "SELECT id, projectName, projectValue, "
                            + "techLeadID, clientID FROM `project` "
                            + "ORDER BY projectValue desc LIMIT 1;";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                project = new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("projectName"),
                        resultSet.getDouble("projectValue"),
                        resultSet.getInt("techLeadID"),
                        resultSet.getInt("clientID")
                );
            }
            }
        return project;
    }

    public int createProject(final ProjectDetailsRequest projectDetailsRequest)
            throws SQLException {

        Connection c = DatabaseConnector.getConnection();
        String insertStatement = "INSERT INTO project "
                + "(projectName, projectValue, techLeadID, clientID) "
                + "VALUES (?,?,?,?);";
        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);
        st.setString(1, projectDetailsRequest.getProjectName());
        st.setDouble(2, projectDetailsRequest.getProjectValue());
        st.setInt(stIntMaxThree, projectDetailsRequest.getTechLead());
        st.setInt(stIntMaxFour, projectDetailsRequest.getClientId());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);

        }
        return -1;
    }
}
