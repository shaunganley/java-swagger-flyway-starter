package org.example.daos;

import org.example.models.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles() throws SQLException {
        List<JobRole> jobRolesList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT roleName, location, capability, band, closingDate FROM `Role`;");
            while (resultSet.next()) {
                 JobRole role = new JobRole(
                        resultSet.getString("roleName"),
                        resultSet.getString("location"),
                         resultSet.getString("capability"),
                         resultSet.getString("band"),
                         resultSet.getDate("closingDate")
                );

                jobRolesList.add(role);
            }

        }
        return jobRolesList;
    }
}
