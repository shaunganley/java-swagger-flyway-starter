package org.example.controller;

import org.example.controllers.JobRoleController;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRole;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JobRolesControllerTests {
    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    void getJobRolesShouldReturnJobRolesWhenServiceReturnsJobRoles()
            throws SQLException,
            DatabaseConnectionException {
        List<JobRole> jobRoleList = new ArrayList<>();

        when(jobRoleService.getJobRoles()).thenReturn(jobRoleList);

        Response response = jobRoleController.getJobRoles();

        assertEquals(200, response.getStatus());
        assertEquals(jobRoleList, response.getEntity());
    }

    @Test
    void getJobRolesShould500WhenServiceThrowsSQLException()
            throws SQLException,
            DatabaseConnectionException {
        when(jobRoleService.getJobRoles()).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        assertEquals(500, response.getStatus());
    }

    @Test
    void getJobRolesShould500WhenServiceThrowsDataBaseConnectionException()
            throws SQLException,
            DatabaseConnectionException {
        when(jobRoleService.getJobRoles()).thenThrow(DatabaseConnectionException.class);

        Response response = jobRoleController.getJobRoles();

        assertEquals(500, response.getStatus());
    }
}
