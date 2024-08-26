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
                    "select job_roles.roleName, "
                            + "job_roles.location, "
                            + "capability.capabilityName, "
                            + "band.bandName, job_roles.closingDate"
                            + "from job_roles"
                            + "join capability on job_roles.capabilityId = "
                            + "capability.capabilityId"
                            + "join band on job_roles.bandId = band.nameId;");

            while (resultSet.next()) {
                JobRole jobRole = new JobRole(
                        resultSet.getString("job_roles.roleName"),
                        resultSet.getString("job_roles.location"),
                        resultSet.getString("capability.capabilityName"),
                        resultSet.getString("band.bandName"),
                        resultSet.getDate("job_roles.closingDate"));
                jobRoles.add(jobRole);
            }
        }
        return jobRoles;
    }

}
