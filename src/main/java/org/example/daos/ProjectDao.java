package org.example.daos;

import org.example.models.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDao {

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
}
