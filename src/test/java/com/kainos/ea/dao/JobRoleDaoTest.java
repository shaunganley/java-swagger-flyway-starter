/*
package com.kainos.ea.dao;

import org.example.daos.JobRoleDao;
import org.example.models.JobRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobRoleDaoTest {

    @Test
    public void testGetAllJobRoles() throws SQLException {

        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false); // Simulate two rows in the result set

        when(mockResultSet.getString("job_roles.roleName")).thenReturn("Software Engineer", "Marketing Specialist");
        when(mockResultSet.getString("job_roles.location")).thenReturn("New York", "San Francisco");
        when(mockResultSet.getString("capability.capabilityName")).thenReturn("Software Development", "Data Science");
        when(mockResultSet.getString("band.bandName")).thenReturn("Junior", "Mid");
        when(mockResultSet.getTimestamp("job_roles.closingDate"))
                .thenReturn(Timestamp.valueOf("2024-09-15 17:00:00"), Timestamp.valueOf("2024-09-20 17:00:00"));

        JobRoleDao jobRoleDao = new JobRoleDao();

        List<JobRole> jobRoles = jobRoleDao.getAllJobRoles();

        assertEquals(2, jobRoles.size()); // Verify two job roles were retrieved
        assertEquals("Software Engineer", jobRoles.get(0).getRoleName());
        assertEquals("Marketing Specialist", jobRoles.get(1).getRoleName());
    }
}
*/
