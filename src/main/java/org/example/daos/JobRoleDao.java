package org.example.daos;

import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {

    public List<JobRole> getAllJobRoles() throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT jobRoleId, roleName, location, statusId, statusName, capabilityName, "
                            + "bandName, closingDate\n"
                            + "FROM job_roles\n"
                            + "INNER JOIN capability USING(capabilityId)\n"
                            + "INNER JOIN band USING(bandId)\n"
                            + "INNER JOIN status using(statusId)\n"
                            + "WHERE statusName = 'open';");

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
                    resultSet.getDate("closingDate"),
                    resultSet.getString("statusName")
            );
        } catch (SQLException e) {
            throw new ResultSetException(e.getMessage());
        }

        jobRoles.add(jobRole);
    }

    public boolean existsOpenById(int jobRoleId) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT * FROM job_roles WHERE jobRoleId = ? AND statusId = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, jobRoleId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }
    }
}
