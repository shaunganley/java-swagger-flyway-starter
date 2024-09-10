package org.example.daos;

import org.example.models.JobRole;
import org.example.models.JobRoleRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                            resultSet.getInt("job_roles.jobRoleId"),
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

    public JobRole getJobRoleById(final int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT "
                    + "job_roles.jobRoleId, "
                    + "job_roles.roleName, "
                    + "job_roles.description, "
                    + "job_roles.responsibilities, "
                    + "job_roles.sharepointUrl, "
                    + "job_roles.location, "
                    + "band.bandName, "
                    + "capability.capabilityName, "
                    + "job_roles.closingDate, "
                    + "status.statusName, "
                    + "job_roles.numberOfOpenPositions "
                    + "FROM "
                    + "job_roles "
                    + "JOIN "
                    + "capability ON job_roles.capabilityId"
                    +
                    " = capability.capabilityId "
                    + "JOIN "
                    + "band ON job_roles.bandId = band.nameId "
                    + "JOIN "
                    + "status ON job_roles.statusId = status.statusId "
                    + "WHERE "
                    + "job_roles.jobRoleId = ?;";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                return new JobRole(
                        resultSet.getInt("jobRoleId"),
                        resultSet.getString("roleName"),
                        resultSet.getString("description"),
                        resultSet.getString("responsibilities"),
                        resultSet.getString("sharepointUrl"),
                        resultSet.getString("location"),
                        resultSet.getString("capabilityName"),
                        resultSet.getString("bandName"),
                        resultSet.getDate("closingDate"),
                        resultSet.getString("statusName"),
                        resultSet.getInt("numberOfOpenPositions"));
            }

            return null;
        }
    }

    public int createJobRole(final JobRoleRequest jobRole) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO job_roles (roleName, description, sharepointUrl, "
                        + "responsibilities, numberOfOpenPositions, "
                        + "location, closingDate, "
                        + "capabilityId, bandId, statusId) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";

        final int roleNameIndex = 1;
        final int descriptionIndex = 2;
        final int sharepointUrlIndex = 3;
        final int responsibilitiesIndex = 4;
        final int numberOfOpenPositionsIndex = 5;
        final int locationIndex = 6;
        final int closingDateIndex = 7;
        final int capabilityNameIndex = 8;
        final int bandNameIndex = 9;

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertStatement,
                        Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(roleNameIndex,
                jobRole.getRoleName());
        preparedStatement.setString(descriptionIndex,
                jobRole.getDescription());
        preparedStatement.setString(sharepointUrlIndex,
                jobRole.getSharepointUrl());
        preparedStatement.setString(responsibilitiesIndex,
                jobRole.getResponsibilities());
        preparedStatement.setInt(numberOfOpenPositionsIndex,
                jobRole.getNumberOfOpenPositions());
        preparedStatement.setString(locationIndex,
                jobRole.getLocation());
        preparedStatement.setDate(closingDateIndex,
                jobRole.getClosingDate());
        preparedStatement.setString(capabilityNameIndex,
                jobRole.getCapabilityName());
        preparedStatement.setString(bandNameIndex,
                jobRole.getBandName());


        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return -1;
    }

}
