package org.example.daos;

import org.example.models.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {

    public List<Project> getHighestValueProject() throws SQLException {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, projectName, projectValue, "
                           + "techLeadID, clientID FROM `project` "
                           + "ORDER BY projectValue desc LIMIT 1;");

            while (resultSet.next()) {
                Project project = new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("projectName"),
                        resultSet.getDouble("projectValue"),
                        resultSet.getInt("techLeadID"),
                        resultSet.getInt("clientID")
                        );

                projects.add(project);
            }
            return projects;
        }
    }
}
