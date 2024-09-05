package org.example.daos;

import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleDetails;
import org.example.models.JobRoleApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            "SELECT jobRoleId, roleName, location, statusId, statusName, capabilityName, bandName, closingDate\n"
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

    public JobRoleDetails getJobRoleById(final int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query =
                "SELECT roleName, location, capabilityName, bandName, closingDate, statusName, "
                + "description, responsibilities, sharepointUrl, numberOfOpenPositions\n"
                + "FROM job_roles\n"
                + "INNER JOIN capability USING(capabilityId)\n"
                + "INNER JOIN band USING(bandId)\n"
                + "INNER JOIN status using(statusId)\n"
                + "WHERE jobRoleId = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new JobRoleDetails(
                    resultSet.getString("roleName"),
                    resultSet.getString("location"),
                    resultSet.getString("capabilityName"),
                    resultSet.getString("bandName"),
                    resultSet.getDate("closingDate"),
                    resultSet.getString("statusName"),
                    resultSet.getString("description"),
                    resultSet.getString("responsibilities"),
                    resultSet.getString("sharepointUrl"),
                    resultSet.getInt("numberOfOpenPositions")
                );
            }
        }
        return null;
    }

//    public List<JobRoleApplication> getUserJobRoleApplications(int userId)
//            throws SQLException {
//        List<JobRoleApplication> jobRoleApplications = new ArrayList<>();
//
//        try (Connection connection = DatabaseConnector.getConnection()) {
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(
//                    "SELECT jr.roleName, aps.statusName "
//                            + "FROM job_application ja "
//                            + "INNER JOIN application_status aps ON ja.statusId = aps.statusId "
//                            + "INNER JOIN job_roles jr ON ja.roleId = jr.jobRoleId "
//                            + "INNER JOIN user u ON ja.userId = u.userId "
//                            + "WHERE u.userId = " + userId + ";"
//            );
//
//            while(resultSet.next()) {
//                JobRoleApplication jobRoleApplication = new JobRoleApplication(
//                        resultSet.getString("roleName"),
//                        resultSet.getString("statusName")
//                );
//
//                jobRoleApplications.add(jobRoleApplication);
//            }
//        }
//        return jobRoleApplications;
//
//    }
}
