package org.example.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleDetails;
import org.example.models.JobRoleFilteredRequest;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles() throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(baseQuery() + ";");

            while (resultSet.next()) {
                addJobRoleFromResultSet(jobRoles, resultSet);
            }
        }

        return jobRoles;
    }

    public List<JobRole> getFilteredJobRoles(final JobRoleFilteredRequest jobRequest)
            throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();
        StringBuilder query = new StringBuilder(baseQuery());
        List<Object> parameters = new ArrayList<>();

        applyFiltersToQuery(jobRequest, query, parameters);
        executeFilteredJobQuery(query, parameters, jobRoles);

        return jobRoles;
    }

    private static String baseQuery() {
        return "SELECT jobRoleId, roleName, location, statusId, statusName, capabilityName, "
                + "bandName, closingDate\n"
                + "FROM job_roles\n"
                + "INNER JOIN capability USING(capabilityId)\n"
                + "INNER JOIN band USING(bandId)\n"
                + "INNER JOIN status using(statusId)\n"
                + "WHERE statusName = 'open'";
    }

    private void executeFilteredJobQuery(
            final StringBuilder query, final List<Object> parameters, final List<JobRole> jobRoles)
            throws SQLException, ResultSetException {
        try (Connection connection = DatabaseConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query.toString())) {

            setParameters(statement, parameters);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                addJobRoleFromResultSet(jobRoles, resultSet);
            }
        }
    }

    private void setParameters(final PreparedStatement statement, final List<Object> parameters) throws SQLException {
        for (int i = 0; i < parameters.size(); i++) {
            Object param = parameters.get(i);
            if (param instanceof String) {
                statement.setString(i + 1, (String) param);
            } else if (param instanceof Integer) {
                statement.setInt(i + 1, (Integer) param);
            } else if (param instanceof Date) {
                statement.setDate(i + 1, (Date) param);
            } else {
                throw new IllegalArgumentException(
                        "Unsupported parameter type: " + param.getClass().getName());
            }
        }
    }

    private void appendFilter(
            final StringBuilder query, final List<Object> parameters, final String key, final Object value) {
        if (value != null && !value.toString().isBlank()) {
            if ("closingDate".equals(key) && value instanceof Date) {
                query.append(" AND ").append(key).append(" < ?");
                parameters.add(value);
            } else if (value instanceof String && ((String) value).contains(",")) {
                // Handle comma-separated values
                query.append(" AND ").append(key).append(" IN (");
                String[] values = ((String) value).split(",");
                query.append(String.join(", ", Collections.nCopies(values.length, "?")));
                query.append(")");
                parameters.addAll(Arrays.asList(values));
            } else if (value instanceof List) {
                // Handle list of values
                List<?> values = (List<?>) value;
                if (!values.isEmpty()) {
                    query.append(" AND ").append(key).append(" IN (");
                    query.append(String.join(", ", Collections.nCopies(values.size(), "?")));
                    query.append(")");
                    parameters.addAll(values);
                }
            } else {
                // Handle single value
                query.append(" AND ").append(key).append(" LIKE ?");
                parameters.add(value);
            }
        }
    }

    private void applyFiltersToQuery(
            final JobRoleFilteredRequest jobRequest, final StringBuilder query, final List<Object> parameters) {
        appendFilter(query, parameters, "roleName", jobRequest.getLikeRoleName());
        appendFilter(query, parameters, "location", jobRequest.getCommaSeparatedJobRoleLocation());
        appendFilter(query, parameters, "capabilityName", jobRequest.getCapabilityName());
        appendFilter(query, parameters, "bandName", jobRequest.getBandName());
        appendFilter(query, parameters, "closingDate", jobRequest.getClosingDate());

        query.append(";");
    }

    private <E> boolean isPresent(final List<E> list) {
        return list != null && !list.isEmpty();
    }

    private void addJobRoleFromResultSet(final List<JobRole> jobRoles, final ResultSet resultSet)
            throws ResultSetException {
        JobRole jobRole;
        try {
            jobRole = new JobRole(
                    resultSet.getInt("jobRoleId"),
                    resultSet.getString("roleName"),
                    resultSet.getString("location"),
                    resultSet.getString("capabilityName"),
                    resultSet.getString("bandName"),
                    resultSet.getDate("closingDate"),
                    resultSet.getString("statusName"));
        } catch (SQLException e) {
            throw new ResultSetException(e.getMessage());
        }

        jobRoles.add(jobRole);
    }

    public JobRoleDetails getJobRoleById(final int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT roleName, location, capabilityName, bandName, closingDate, statusName, "
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
                        resultSet.getInt("numberOfOpenPositions"));
            }
        }
        return null;
    }
}
