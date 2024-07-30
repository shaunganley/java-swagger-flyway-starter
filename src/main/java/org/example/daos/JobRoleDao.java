
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
                JobRole role = new JobRole(
                        resultSet.getInt("id"),
                        resultSet.getString("roleName"),
                        resultSet.getString("location"),
                        resultSet.getString("capability"),
                        resultSet.getString("band"),
                        resultSet.getDate("closingDate"),
                        resultSet.getString("status"),
                        resultSet.getString("description"),
                        resultSet.getString("responsibilities"),
                        resultSet.getString("jobSpec"));

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
            return new JobRole(resultSet.getInt("id"),
                    resultSet.getString("roleName"),
                    resultSet.getString("location"),
                    resultSet.getString("capability"),
                    resultSet.getString("band"),
                    resultSet.getDate("closingDate"),
                    resultSet.getString("status"),
                    resultSet.getString("description"),
                    resultSet.getString("responsibilities"),
                    resultSet.getString("jobSpec"));
        }
        return null;
    }
}
