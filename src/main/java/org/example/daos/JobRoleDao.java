
package org.example.daos;

import org.example.models.JobRoles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    public List<JobRoles> getAllJobRoles(Connection connection) throws SQLException {
        List<JobRoles> jobRolesList = new ArrayList<>();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT roleName, location, capability, band, " +
                            "closingDate, status FROM `Role` where status='open';");
            while (resultSet.next()) {
                JobRoles role = new JobRoles(
                        resultSet.getString("roleName"),
                        resultSet.getString("location"),
                        resultSet.getString("capability"),
                        resultSet.getString("band"),
                        resultSet.getDate("closingDate"),
                        resultSet.getString("status")
                );

                jobRolesList.add(role);
            }

        return jobRolesList;
    }
}
