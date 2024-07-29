package service;

import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.services.JobRoleService;
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
class JobRoleServiceTest {

    JobRoleDao mockJobRoleDao = Mockito.mock(JobRoleDao.class);
    DatabaseConnector mockDatabaseConnector = Mockito.mock(DatabaseConnector.class);

    JobRoleService jobRoleService = new JobRoleService(mockJobRoleDao, mockDatabaseConnector);

    Connection conn;

    @Test
    void getAllRoles_ShouldReturnRoles() throws SQLException {
        List<JobRoleResponse> jobRolesList = new ArrayList<>();

        Mockito.when(mockDatabaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(mockJobRoleDao.getAllJobRoles(conn)).thenReturn(jobRolesList);

        assertEquals(jobRolesList, jobRoleService.getAllRoles());
    }

    @Test
    void getAllRoles_ShouldThrowSQLExceptionWhenDaoThrowsSQLException() throws SQLException {

        Mockito.when(mockDatabaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(mockJobRoleDao.getAllJobRoles(conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.getAllRoles());
    }
}
