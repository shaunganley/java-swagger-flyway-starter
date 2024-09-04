package org.example.daos;

import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleApplication;

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
                    "SELECT jobRoleId, roleName, location, status, capabilityName, bandName, closingDate FROM job_roles"
                            + " INNER JOIN capability USING(capabilityId)"
                            + " INNER JOIN band USING(bandId)"
                            + " WHERE status = 'open';");

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
                    resultSet.getString("status")
            );
        } catch (SQLException e) {
            throw new ResultSetException(e.getMessage());
        }

        jobRoles.add(jobRole);
    }

    public List<JobRoleApplication> getUserJobRoleApplications(int userId)
            throws SQLException {
        List<JobRoleApplication> jobRoleApplications = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT jr.roleName, aps.statusName "
                            + "FROM job_application ja "
                            + "INNER JOIN application_status aps ON ja.statusId = aps.statusId "
                            + "INNER JOIN job_roles jr ON ja.roleId = jr.jobRoleId "
                            + "INNER JOIN user u ON ja.userId = u.userId "
                            + "WHERE u.userId = " + userId + ";"
            );

            while(resultSet.next()) {
                JobRoleApplication jobRoleApplication = new JobRoleApplication(
                        resultSet.getString("roleName"),
                        resultSet.getString("statusName")
                );

                jobRoleApplications.add(jobRoleApplication);
            }
        }

        return jobRoleApplications;

    }
}
