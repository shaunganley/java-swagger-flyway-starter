package org.example.daos;

import org.example.enums.Direction;
import org.example.enums.JobRoleColumn;
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

    private static final int ROLE_NAME_INDEX = 1;
    private static final int DESCRIPTION_INDEX = 2;
    private static final int SHAREPOINT_URL_INDEX = 3;
    private static final int RESPONSIBILITIES_INDEX = 4;
    private static final int NUMBER_OF_OPEN_POSITIONS_INDEX = 5;
    private static final int LOCATION_INDEX = 6;
    private static final int CLOSING_DATE_INDEX = 7;
    private static final int CAPABILITY_ID_INDEX = 8;
    private static final int BAND_ID_INDEX = 9;

    public List<JobRole> getOpenJobRoles(final String orderBy,
                                         final String direction)
            throws SQLException {
        List<JobRole> jobRoles = new ArrayList<>();

        if (orderBy != null && direction != null) {
            boolean isValidColumn = isValidEnumValue(
                    JobRoleColumn.class, orderBy);
            boolean isValidDirection = isValidEnumValue(
                    Direction.class, direction);

            if (!isValidColumn || !isValidDirection) {
                throw new IllegalArgumentException(
                        "Invalid order by or direction");
            }
        }

        try (Connection connection = DatabaseConnector.getConnection()) {

            String query =
                    "select DISTINCT job_roles.jobRoleId, job_roles.roleName, "
                            + "job_roles.location, "
                            + "capability.capabilityName, band.bandName, "
                            + "job_roles.closingDate "
                            + "from job_roles "
                            + "join capability on job_roles.capabilityId = "
                            + "capability.capabilityId "
                            + "join band on job_roles.bandId = band.nameId "
                            + "join status on status.statusId "
                            + "where job_roles.statusId = 1 ";

            if (orderBy != null && direction != null) {
                query += String.format("ORDER BY %s %s", orderBy, direction);
            }

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

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertStatement,
                        Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(ROLE_NAME_INDEX,
                jobRole.getRoleName());
        preparedStatement.setString(DESCRIPTION_INDEX,
                jobRole.getDescription());
        preparedStatement.setString(SHAREPOINT_URL_INDEX,
                jobRole.getSharepointUrl());
        preparedStatement.setString(RESPONSIBILITIES_INDEX,
                jobRole.getResponsibilities());
        preparedStatement.setInt(NUMBER_OF_OPEN_POSITIONS_INDEX,
                jobRole.getNumberOfOpenPositions());
        preparedStatement.setString(LOCATION_INDEX,
                jobRole.getLocation());
        preparedStatement.setDate(CLOSING_DATE_INDEX,
                jobRole.getClosingDate());
        preparedStatement.setInt(CAPABILITY_ID_INDEX,
                jobRole.getCapabilityId());
        preparedStatement.setInt(BAND_ID_INDEX,
                jobRole.getBandId());


        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return -1;
    }

    private static <T extends Enum<T>> boolean isValidEnumValue(
            final Class<T> enumClass, final String value) {
        for (T enumValue : enumClass.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
