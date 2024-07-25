package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles(final Connection c)
            throws SQLException, DatabaseConnectionException {
        List<JobRole> jobRoles = new ArrayList<>();

            Statement statement = c.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT "
                            + "jr.id, "
                            + "r.name AS `RoleName`, "
                            + "l.name AS `Location`, "
                            + "c.name AS `Capability`, "
                            + "b.name AS `Band`, "
                            + "jr.closing_date AS `ClosingDate` "
                            + "FROM jobRoles jr "
                            + "INNER JOIN role r ON jr.role_id = r.id "
                            + "INNER JOIN location l ON jr.location_id = l.id "
                            + "INNER JOIN capability c "
                            + "ON jr.capability_id = c.id "
                            + "INNER JOIN band b ON jr.band_id = b.id "
                            + "WHERE jr.status = 'open';"
            );

            while (resultSet.next()) {
                JobRole jobRole = new JobRole(
                        resultSet.getInt("id"),
                        resultSet.getString("RoleName"),
                        resultSet.getString("Location"),
                        resultSet.getString("Capability"),
                        resultSet.getString("Band"),
                        resultSet.getDate("ClosingDate"),
                        "open"
                );

                jobRoles.add(jobRole);
        }

        return jobRoles;
    }
}
