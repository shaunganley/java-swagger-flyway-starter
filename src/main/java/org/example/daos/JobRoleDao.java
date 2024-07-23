package org.example.daos;

import org.example.models.JobRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles() throws SQLException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT\n"
                            +
                            "    jr.id,\n"
                            +
                            "    r.name AS `RoleName`,\n"
                            +
                            "    l.name AS `Location`,\n"
                            +
                            "    c.name AS `Capability`,\n"
                            +
                            "    b.name AS `Band`,\n"
                            +
                            "    jr.closing_date AS `ClosingDate`\n"
                            +
                            "FROM\n"
                            +
                            "    jobRoles jr\n"
                            +
                            "INNER JOIN role r ON jr.role_id = r.id\n"
                            +
                            "INNER JOIN location l ON jr.location_id = l.id\n"
                            +
                            "INNER JOIN capability c "
                            +
                            "ON jr.capability_id = c.id\n"
                            +
                            "INNER JOIN band b ON jr.band_id = b.id\n"
                            +
                            "WHERE jr.status = 'open';"
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jobRoles;
    }
}
