package com.kainos.ea.controller;

import org.example.controllers.JobRoleController;
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

@ExtendWith(MockitoExtension.class)
public class JobRoleControllerTest {

    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);

    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    public void getJobRoles_shouldReturnResponseCode200WithJobRoleResponses_whenNoErrorsThrown() throws SQLException {

        long millis=System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleResponse jobRoleResponse = new JobRoleResponse("SE", "Derry",
                "Eng", "Band 4", closingDate);

        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();
        jobRoleResponses.add(jobRoleResponse);

        Response expectedResponse = Response.ok().entity(jobRoleResponses).build();

        Mockito.when(jobRoleService.getAllJobRoles()).thenReturn(jobRoleResponses);

        Response actualResponse = Response.ok().entity(jobRoleService.getAllJobRoles()).build();

        Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());

        Assert.assertEquals(expectedResponse.getEntity(), actualResponse.getEntity());
    }

    @Test
    public void getJobRoles_shouldReturnResponseCode500_whenServiceThrowsSqlException() throws SQLException {
        Mockito.when(jobRoleService.getAllJobRoles()).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

}
