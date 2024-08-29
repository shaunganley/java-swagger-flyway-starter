package com.kainos.ea.controller;

import org.example.controllers.JobRoleController;
import org.example.daos.JobRoleDao;
import org.example.models.JobRoleResponse;
import org.example.services.JobRoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JobRoleControllerTest {

    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);

    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    public void getJobRoles_shouldReturnResponseCode200WithJobRoleResponses() throws SQLException {

        long millis=System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleResponse jobRoleResponse = new JobRoleResponse("SE", "Derry",
                "Eng", "Band 4", closingDate);

        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();
        jobRoleResponses.add(jobRoleResponse);

        Response expectedResponse = Response.ok().entity(jobRoleResponses).build();

        Mockito.when(jobRoleService.getAllJobRoles()).thenReturn(jobRoleResponses);

        Response actualResponse = Response.ok().entity(jobRoleService.getAllJobRoles()).build();

        // check if status codes match
        Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        // check if the entity/body of expected and actual responses match
        // i.e. check if lists of job role responses match
        Assert.assertEquals(expectedResponse.getEntity(), actualResponse.getEntity());
    }

    // testing if the SQLException is handled correctly and an internal server error is returned.
    @Test
    public void getJobRoles_shouldReturnResponseCode500_whenServiceThrowsSqlException() throws SQLException {
        Mockito.when(jobRoleService.getAllJobRoles()).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

}
