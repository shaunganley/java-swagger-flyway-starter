package org.example.daos;

import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleFilteredRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles()
            throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    baseQuery() + ";");

            while (resultSet.next()) {
                addJobRoleFromResultSet(jobRoles, resultSet);
            }
        }

        return jobRoles;
    }

    public List<JobRole> getFilteredJobRoles(
            final JobRoleFilteredRequest jobRequest)
            throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();
        StringBuilder query = new StringBuilder(baseQuery());
        List<Object> parameters = new ArrayList<>();

        applyFiltersToQuery(jobRequest, query, parameters);
        executeFilteredJobQuery(query, parameters, jobRoles);

        return jobRoles;
    }

    private static String baseQuery() {
        return
                "SELECT jobRoleId, roleName, location, statusId, statusName, capabilityName, "
                        + "bandName, closingDate\n"
                        + "FROM job_roles\n"
                        + "INNER JOIN capability USING(capabilityId)\n"
                        + "INNER JOIN band USING(bandId)\n"
                        + "INNER JOIN status using(statusId)\n"
                        + "WHERE statusName = 'open'";
    }

    private void applyFiltersToQuery(final JobRoleFilteredRequest jobRequest,
                                     final StringBuilder query,
                                     final List<Object> parameters) {
        if (jobRequest.getRoleName() != null && !jobRequest.getRoleName().isBlank()) {
            query.append(" AND roleName LIKE ?");
            parameters.add(jobRequest.getLikeRoleName());
        }
        applyFilter(jobRequest.getJobRoleLocation(), "location", query,
                parameters);
        applyFilter(jobRequest.getCapabilityId(), "capabilityId", query,
                parameters);
        applyFilter(jobRequest.getBandId(), "bandId", query, parameters);
        if (jobRequest.getClosingDate() != null) {
            query.append(" AND closingDate < ?");
            parameters.add(jobRequest.getClosingDate());
        }

        query.append(";");

    }

    private void executeFilteredJobQuery(final StringBuilder query, final List<Object> parameters,
                                         final List<JobRole> jobRoles)
            throws SQLException, ResultSetException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    query.toString())) {
                for (int i = 0; i < parameters.size(); i++) {
                    if (parameters.get(i) instanceof String) {
                        statement.setString(i + 1, (String) parameters.get(i));
                    } else if (parameters.get(i) instanceof Integer) {
                        statement.setInt(i + 1, (Integer) parameters.get(i));
                    } else if (parameters.get(i) instanceof java.sql.Date) {
                        statement.setDate(i + 1, (java.sql.Date) parameters.get(i));
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    addJobRoleFromResultSet(jobRoles, resultSet);
                }
            }
        }
    }

    private <T> void applyFilter(final List<T> values, final String key,
                                 final StringBuilder query, final List<Object> parameters) {
        if (isPresent(values)) {
            query.append(" AND ").append(key).append(" IN (");
            query.append(String.join(", ", Collections.nCopies(
                    values.size(), "?")));
            query.append(")");
            parameters.addAll(values);
        }
    }


    private <E> boolean isPresent(final List<E> list) {
        return list != null && !list.isEmpty();
    }

    private void addJobRoleFromResultSet(final List<JobRole> jobRoles,
                                         final ResultSet resultSet)
            throws ResultSetException {
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
}
