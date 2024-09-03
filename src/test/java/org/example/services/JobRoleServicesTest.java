package org.example.services;

import org.example.daos.JobRoleDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleDetails;
import org.example.models.JobRoleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobRoleServicesTest {
    List<JobRole> jobRoles;
    JobRoleDao jobRoleDao = Mockito.mock(JobRoleDao.class);
    JobRoleService jobRoleService = new JobRoleService(jobRoleDao);

    @BeforeEach
    public void jobRolesListClean() {
        jobRoles = new ArrayList<>();
    }

    @Test
    public void getAllJobRoles_shouldReturnListOfJobRoles() throws SQLException, ResultSetException {
        jobRoles.add(
                new JobRole(3, "test", "Belfast", "testCapability", "testBand", Date.valueOf("2000-10-10"), "open")
        );
        jobRoles.add(
                new JobRole(2, "test2", "Belfast", "testCapability2", "testBand2", Date.valueOf("2000-10-11"), "closed")
        );
        Mockito.when(jobRoleDao.getAllJobRoles()).thenReturn(jobRoles);

        List<JobRoleResponse> expected = new ArrayList<>();
        expected.add(
                new JobRoleResponse(1, "test", "Belfast", "testCapability", "testBand", Date.valueOf("2000-10-10"), "open")
        );
    }

    @Test
    public void getAllJobRoles_WhenDaoReturnsNull_ExpectDoesNotExistExceptionToBeThrown()
            throws SQLException, ResultSetException {
        Mockito.when(jobRoleDao.getAllJobRoles()).thenReturn(new ArrayList<>());
        assertThrows(DoesNotExistException.class, () -> jobRoleService.getAllJobRoles());
    }

    @Test
    public void getAllJobRoles_WhenDaoThrowsSQLException_ExpectSQLExceptionToBeThrown()
            throws SQLException, ResultSetException {
        Mockito.when(jobRoleDao.getAllJobRoles()).thenThrow(SQLException.class);
        assertThrows(SQLException.class, () -> jobRoleService.getAllJobRoles());
    }

    @Test
    public void getJobRoleById_shouldReturnJobRoleDetails()
            throws SQLException, DoesNotExistException {
        JobRoleDetails expectedResult = new JobRoleDetails(
                "test",
                "Belfast",
                "testCapability",
                "testBand",
                Date.valueOf("2000-10-11"),
                "open",
                "testDescription",
                "testResponsibilities",
                "http://url.com",
                2);
        Mockito.when(jobRoleDao.getJobRoleById(1)).thenReturn(expectedResult);
        JobRoleDetails result = jobRoleService.getJobRoleById(1);
        assertEquals(result, expectedResult);
    }

    @Test
    public void getJobRoleById_whenDaoThrowsSQLException_ExpectSQLExceptionToBeThrown()
            throws SQLException {
        Mockito.when(jobRoleDao.getJobRoleById(1)).thenThrow(SQLException.class);
        assertThrows(SQLException.class, () -> jobRoleService.getJobRoleById(1));
    }

    @Test
    public void getJobRoleById_whenDaoReturnsNull_ExpectDoesNotExistExceptionToBeThrown()
            throws SQLException {
        Mockito.when(jobRoleDao.getJobRoleById(1)).thenReturn(null);
        assertThrows(DoesNotExistException.class, () -> jobRoleService.getJobRoleById(1));
    }
}
