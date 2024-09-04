package org.example.daos;

import org.example.models.JobRole;
import org.example.models.JobRoleDetailedResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {

    public List<JobRole> getOpenJobRoles()
            throws SQLException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {

            String query =
                    "select job_roles.jobRoleId, job_roles.roleName, "
                            + "job_roles.location, "
                            + "capability.capabilityName, band.bandName, "
                            + "job_roles.closingDate "
                            + "from job_roles "
                            + "join capability on job_roles.capabilityId = "
                            + "capability.capabilityId "
                            + "join band on job_roles.bandId = band.nameId "
                            + "join status on status.statusId "
                            + "where job_roles.statusId = 1 "
                            + "group by job_roles.jobRoleId;";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    jobRoles.add(new JobRole(
                            resultSet.getInt("job_roles.getJobRoleId"),
                            resultSet.getString("job_roles.roleName"),
                            resultSet.getString("job_roles.location"),
                            resultSet.getString("capability.capabilityName"),
                            resultSet.getString("band.bandName"),
                            resultSet.getDate("job_roles.closingDate")));
                }
            }
        }
        return jobRoles;
    }

    public JobRole getJobRoleById(final int id)
            throws SQLException {

        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT "
                    +
                    "job_roles.roleName, "
                    +
                    "job_roles.description, "
                    +
                    "job_roles.responsibilities, "
                    +
                    "job_roles.sharepointUrl, "
                    +
                    "job_roles.location, "
                    +
                    "band.bandName, "
                    +
                    "capability.capabilityName, "
                    +
                    "job_roles.closingDate, "
                    +
                    "status.statusName, "
                    +
                    "job_roles.numberOfOpenPositions "
                    +
                    "FROM "
                    +
                    "job_roles "
                    +
                    "JOIN "
                    +
                    "capability ON job_roles.capabilityId = "
                    +
                    "capability.capabilityId "
                    +
                    "JOIN "
                    +
                    "band ON job_roles.bandId = band.nameId "
                    +
                    "JOIN "
                    +
                    "status ON job_roles.statusId = status.statusId "
                    +
                    "WHERE "
                    +
                    "job_roles.jobRoleId = ?;";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                if (resultSet.next()) {
                    return new JobRole(
                            resultSet.getInt(1),
                            resultSet.getString("job_roles.roleName"),
                            resultSet.getString("job_roles.description"),
                            resultSet.getString("job_roles.responsibilities"),
                            resultSet.getString("job_roles.sharepointUrl"),
                            resultSet.getString("job_roles.location"),
                            resultSet.getString("capability.capabilityName"),
                            resultSet.getString("band.bandName"),
                            resultSet.getDate("job_roles.closingDate"),
                            resultSet.getString("status.statusName"),
                            resultSet.getInt(
                                    "job_roles.numberOfOpenPositions"));
                }
            }
            return null;
        }
    }
}
