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
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT (roleName, location, capabilityName, bandName, closingDate) FROM job-roles"
                            + "INNER JOIN capabilities USING(capabilityId)"
                            + "INNER JOIN band USING(bandId);");

            while (resultSet.next()) {
                JobRole jobRole;
                jobRole = new JobRole(resultSet.getInt("jobRoleId"),
                        resultSet.getString("roleName"),
                        resultSet.getString("jobRoleLocation"),
                        resultSet.getString("capabilityName"),
                        resultSet.getString("bandName"),
                        resultSet.getDate("closingDate")
                        );
                jobRoles.add(jobRole);
            }
        }

        return jobRoles;
    }
}
