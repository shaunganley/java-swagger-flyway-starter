package org.example.services;
import org.example.daos.JobRoleDao;
import org.example.enums.Direction;
import org.example.enums.JobRoleColumn;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.JobRole;
import org.example.models.JobRoleDetailedResponse;
import org.example.models.JobRoleRequest;
import org.example.models.JobRoleResponse;
import org.example.validators.JobRoleValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobRoleServiceTest {

    JobRoleDao jobRoleDao = Mockito.mock(JobRoleDao.class);
    JobRoleValidator jobRoleValidator = Mockito.mock(JobRoleValidator.class);

    JobRoleService jobRoleService = new JobRoleService(jobRoleDao, jobRoleValidator);

    @Test
    public void getAllJobRoles_shouldReturnJobRoleResponseList() throws SQLException {

        long millis=System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRole jobRole1 = new JobRole(1,"SE", "Derry",
                "Eng", "Band 4", closingDate);

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(jobRole1);

        JobRoleResponse jobRoleResponse = new JobRoleResponse(1,"SE", "Derry",
                "Eng", "Band 4", closingDate);

        List<JobRoleResponse> expectedResponse = new ArrayList<>();
        expectedResponse.add(jobRoleResponse);

        when(jobRoleDao.getOpenJobRoles(null, null)).thenReturn(jobRoles);

        List<JobRoleResponse> actualResponse = jobRoleService.getOpenJobRoles(null, null);

        Assert.assertEquals(expectedResponse.size(), actualResponse.size());
        Assert.assertEquals(1, actualResponse.size());

        Assert.assertEquals(
                expectedResponse.get(0).getRoleName(),
                actualResponse.get(0).getRoleName());

        Assert.assertEquals(
                expectedResponse.get(0).getLocation(),
                actualResponse.get(0).getLocation());

        Assert.assertEquals(
                expectedResponse.get(0).getCapabilityName(),
                actualResponse.get(0).getCapabilityName());

        Assert.assertEquals(
                expectedResponse.get(0).getBandName(),
                actualResponse.get(0).getBandName());

        Assert.assertEquals(
                expectedResponse.get(0).getClosingDate(),
                actualResponse.get(0).getClosingDate());
    }

    @Test
    public void getAllJobRoles_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException{

        when(jobRoleDao.getOpenJobRoles(null, null)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.getOpenJobRoles(null, null));

    }

    @Test
    public void getJobRoleById_shouldReturnJobRole() throws SQLException, DoesNotExistException {

        long millis=System.currentTimeMillis();
        Date closingDate = new Date(millis);

        int jobRoleId = 1;
        JobRole expectedJobRole = new JobRole(1,"Software Engineer", "Develops, tests, and maintains software applications.", "Design, develop, and maintain software applications.", "https://sharepoint.com/job/software-engineer", "New York", "Software Development", "Senior", closingDate, "Open", 1);

        when(jobRoleDao.getJobRoleById(jobRoleId)).thenReturn(expectedJobRole);


        JobRoleDetailedResponse actualJobRole = jobRoleService.getJobRoleById(jobRoleId);

        Assert.assertNotNull(actualJobRole);
        assertEquals(expectedJobRole.getRoleName(), actualJobRole.getRoleName());
        assertEquals(expectedJobRole.getLocation(), actualJobRole.getLocation());
        assertEquals(expectedJobRole.getDescription(), actualJobRole.getDescription());
        assertEquals(expectedJobRole.getResponsibilities(), actualJobRole.getResponsibilities());
        assertEquals(expectedJobRole.getSharepointUrl(), actualJobRole.getSharepointUrl());
        assertEquals(expectedJobRole.getNumberOfOpenPositions(), actualJobRole.getNumberOfOpenPositions());
    }

    @Test
    public void getJobRoleById_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException{

        when(jobRoleDao.getJobRoleById(1)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobRoleService.getJobRoleById(1));

    }

    @Test
    public void getJobRoleById_shouldReturnNull_whenJobRoleDoesNotExist() throws SQLException{

        int nonExistentJobRoleId = 999;

        when(jobRoleDao.getJobRoleById(nonExistentJobRoleId)).thenReturn(null);

        assertThrows(DoesNotExistException.class,
                () -> jobRoleService.getJobRoleById(nonExistentJobRoleId));

    }
    @Test
    public void getOpenJobRoles_shouldThrowSQLException_whenDaoThrowsSQLExceptionWithOrdering()
            throws SQLException{
        when(jobRoleDao.getOpenJobRoles(JobRoleColumn.ROLENAME.getColumnName(), Direction.ASC.getDirectionName())).thenThrow(SQLException.class);

        assertThrows(SQLException.class, () -> {
            jobRoleDao.getOpenJobRoles(JobRoleColumn.ROLENAME.getColumnName(), Direction.ASC.getDirectionName());
        });
    }
    @Test
    public void createJobRole_shouldReturnJobRoleId_whenJobRoleCreatedSuccessfully()
            throws SQLException, InvalidException {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );

        int expectedJobRoleId = 1;

        Mockito.doNothing().when(jobRoleValidator).validateJobRole(jobRoleRequest);
        Mockito.when(jobRoleDao.createJobRole(jobRoleRequest)).thenReturn(expectedJobRoleId);

        int actualJobRoleId = jobRoleService.createJobRole(jobRoleRequest);

        assertEquals(expectedJobRoleId, actualJobRoleId);
    }

    @Test
    public void createJobRole_shouldThrowSQLException_whenDaoThrowsSQLException() throws SQLException, InvalidException {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );

        Mockito.doNothing().when(jobRoleValidator).validateJobRole(jobRoleRequest);
        Mockito.when(jobRoleDao.createJobRole(jobRoleRequest)).thenThrow(SQLException.class);

        assertThrows(SQLException.class, () -> jobRoleService.createJobRole(jobRoleRequest));
    }

    @Test
    public void createJobRole_shouldThrowInvalidException_whenValidationFails() throws InvalidException {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Invalid Role Name",
                "",
                "https://invalid.url",
                "",
                0,
                "",
                closingDate,
                0,
                0
        );

        Mockito.doThrow(new InvalidException(Entity.JOB_ROLE, "Invalid Job Role Request"))
                .when(jobRoleValidator).validateJobRole(jobRoleRequest);

        assertThrows(InvalidException.class, () -> jobRoleService.createJobRole(jobRoleRequest));
    }


}
