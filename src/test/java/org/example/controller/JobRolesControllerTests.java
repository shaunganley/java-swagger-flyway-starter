package org.example.controller;

import org.example.controllers.JobRoleController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRole;
import org.example.models.JobRoleInfo;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JobRolesControllerTests {
    private final JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);
    private final JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    void getJobRolesShouldReturnJobRolesWhenServiceReturnsJobRoles()
            throws SQLException, DatabaseConnectionException {
        List<JobRole> jobRoleList = new ArrayList<>();
        JobRole jobRole = new JobRole(1,
                "Open Test Role",
                "Belfast",
                "Eng",
                "A",
                new Date(),
                "open");
        jobRoleList.add(jobRole);

        when(jobRoleService.getJobRoles()).thenReturn(jobRoleList);

        Response response = jobRoleController.getJobRoles();

        System.out.println("Expected JobRoles: " + jobRoleList);
        System.out.println("Actual JobRoles: " + response.getEntity());

        assertEquals(200, response.getStatus());
        assertEquals(jobRoleList, response.getEntity());
    }

    @Test
    void getJobRolesShould500WhenServiceThrowsSQLException()
            throws SQLException, DatabaseConnectionException {
        when(jobRoleService.getJobRoles()).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        System.out.println("Response Status: " + response.getStatus());

        assertEquals(500, response.getStatus());
    }

    @Test
    void getJobRolesShould500WhenServiceThrowsDatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {
        when(jobRoleService.getJobRoles()).thenThrow(DatabaseConnectionException.class);

        Response response = jobRoleController.getJobRoles();

        System.out.println("Response Status: " + response.getStatus());

        assertEquals(500, response.getStatus());
    }

    @Test
    void getJobRoleByIdShouldReturnJobRoleInfoWhenServiceReturnsJobRoleInfo()
            throws SQLException, DatabaseConnectionException {
        JobRoleInfo jobRoleInfo = new JobRoleInfo(1,
                "Open Test Role",
                "Belfast",
                "Eng",
                "A",
                new Date(),
                "open",
                "Test Description",
                "Test Responsibilities",
                "Test Job Spec");

        when(jobRoleService.getJobRoleById(1)).thenReturn(jobRoleInfo);

        Response response = jobRoleController.getJobRoleById(1);

        System.out.println("Expected JobRoleInfo: " + jobRoleInfo);
        System.out.println("Actual JobRoleInfo: " + response.getEntity());

        assertEquals(200, response.getStatus());
        assertEquals(jobRoleInfo, response.getEntity());
    }

    @Test
    void getJobRoleByIdShouldReturn404WhenServiceReturnsNull()
            throws SQLException, DatabaseConnectionException {
        when(jobRoleService.getJobRoleById(1)).thenReturn(null);

        Response response = jobRoleController.getJobRoleById(1);

        System.out.println("Response Status: " + response.getStatus());

        assertEquals(404, response.getStatus());
    }

    @Test
    void getJobRoleByIdShould500WhenServiceThrowsSQLException()
            throws SQLException, DatabaseConnectionException {
        when(jobRoleService.getJobRoleById(1)).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoleById(1);

        System.out.println("Response Status: " + response.getStatus());

        assertEquals(500, response.getStatus());
    }

    @Test
    void getJobRoleByIdShould500WhenServiceThrowsDatabaseConnectionException()
            throws SQLException, DatabaseConnectionException {
        when(jobRoleService.getJobRoleById(1))
                .thenThrow(DatabaseConnectionException.class);

        Response response = jobRoleController.getJobRoleById(1);

        System.out.println("Response Status: " + response.getStatus());

        assertEquals(500, response.getStatus());
    }
}
