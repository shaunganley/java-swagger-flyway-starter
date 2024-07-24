package org.example.services;
import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class JobRolesServiceTests {

    JobRoleDao jobRoleDao = Mockito.mock(JobRoleDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    JobRoleService jobRoleService = new JobRoleService(jobRoleDao, databaseConnector);

    Connection conn;
    @Test
    void getJobRoles_shouldReturnJobRoles_whenDaoReturnsJobRoles()
        throws SQLException, DatabaseConnectionException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);

        List<JobRole> expected = new ArrayList<JobRole>();
        Mockito.when(jobRoleDao.getAllJobRoles(conn)).thenReturn(expected);

        List<JobRole> result = jobRoleService.getJobRoles();

        assertEquals(expected, result);
    }

    @Test
    void getJobRoles_shouldThrowSQLException_whenDaoThrowsSqlException()
        throws SQLException, DatabaseConnectionException{
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);

        Mockito.when(jobRoleDao.getAllJobRoles(conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class, () -> jobRoleService.getJobRoles());
    }

    @Test
    void getJobRoles_shouldThrowDatabaseConnectionException_whenDaoThrowsDatabaseConnectionException()
            throws SQLException, DatabaseConnectionException{
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);

        Mockito.when(jobRoleDao.getAllJobRoles(conn)).thenThrow(DatabaseConnectionException.class);

        assertThrows(DatabaseConnectionException.class, () -> jobRoleService.getJobRoles());
    }
}
