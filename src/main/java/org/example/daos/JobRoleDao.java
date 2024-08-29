package org.example.daos;

import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles() throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT jobRoleId, roleName, location, capabilityName, bandName, closingDate FROM job_roles"
                            + " INNER JOIN capability USING(capabilityId)"
                            + " INNER JOIN band USING(bandId)"
                            + "WHERE closingDate >= CURDATE();");

            while (resultSet.next()) {
                addJobRoleFromResultSet(jobRoles, resultSet);
            }
        }

        return jobRoles;
    }

    private void addJobRoleFromResultSet(final List<JobRole> jobRoles,
                                         final ResultSet resultSet) throws ResultSetException {
        JobRole jobRole;
        try {
            jobRole = new JobRole(resultSet.getInt("jobRoleId"),
                    resultSet.getString("roleName"),
                    resultSet.getString("location"),
                    resultSet.getString("capabilityName"),
                    resultSet.getString("bandName"),
                    resultSet.getDate("closingDate")
            );
        } catch (SQLException e) {
            throw new ResultSetException(e.getMessage());
        }

        jobRoles.add(jobRole);
    }
}
