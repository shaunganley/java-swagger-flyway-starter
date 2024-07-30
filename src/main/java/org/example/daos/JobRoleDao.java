
package org.example.daos;

import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.InvalidException;
import org.example.models.JobRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles(
            final Connection connection) throws SQLException {
        List<JobRole> jobRolesList = new ArrayList<>();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, roleName, location, "
                            + "capability, band, "
                            + "closingDate, status, description, "
                            + "responsibilities, jobSpec FROM `Role` "
                            + "where status='open';");
            while (resultSet.next()) {
                JobRole role = new JobRole.Builder()
                        .id(resultSet.getInt("id"))
                        .roleName(resultSet.getString("roleName"))
                        .location(resultSet.getString("location"))
                        .capability(resultSet.getString("capability"))
                        .band(resultSet.getString("band"))
                        .closingDate(resultSet.getDate("closingDate"))
                        .status(resultSet.getString("status"))
                        .description(resultSet.getString("description"))
                        .responsibilities(
                                resultSet.getString("responsibilities"))
                        .jobSpec(resultSet.getString("jobSpec"))
                        .build();

                jobRolesList.add(role);
            }

        return jobRolesList;
    }
    public JobRole getJobRoleById(final int id,
                                  final Connection connection)
        throws SQLException, DoesNotExistException, InvalidException {
        String query =
                "SELECT id, roleName, location, "
                        + "capability, band, "
                        + "closingDate, status, description, "
                        + "responsibilities, jobSpec FROM `Role` "
                        + "WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            return new JobRole.Builder()
                    .id(resultSet.getInt("id"))
                    .roleName(resultSet.getString("roleName"))
                    .location(resultSet.getString("location"))
                    .capability(resultSet.getString("capability"))
                    .band(resultSet.getString("band"))
                    .closingDate(resultSet.getDate("closingDate"))
                    .status(resultSet.getString("status"))
                    .description(resultSet.getString("description"))
                    .responsibilities(
                            resultSet.getString("responsibilities"))
                    .jobSpec(resultSet.getString("jobSpec"))
                    .build();
        }
        return null;
    }
}
