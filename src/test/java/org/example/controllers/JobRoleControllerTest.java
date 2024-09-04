package org.example.controllers;

import org.example.exception.DoesNotExistException;
import org.example.models.JobRoleDetailedResponse;
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
    public void getJobRoles_shouldReturnResponseCode200WithJobRoleResponses_whenNoErrorsThrown()
            throws SQLException {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleResponse jobRoleResponse = new JobRoleResponse("SE", "Derry",
                "Eng", "Band 4", closingDate);

        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();
        jobRoleResponses.add(jobRoleResponse);

        Response expectedResponse =
                Response.ok().entity(jobRoleResponses).build();

        Mockito.when(jobRoleService.getOpenJobRoles())
                .thenReturn(jobRoleResponses);

        Response actualResponse =
                Response.ok().entity(jobRoleService.getOpenJobRoles()).build();

        Assert.assertEquals(expectedResponse.getStatus(),
                actualResponse.getStatus());

        Assert.assertEquals(expectedResponse.getEntity(),
                actualResponse.getEntity());
    }

    @Test
    public void getJobRoles_shouldReturnResponseCode500_whenServiceThrowsSqlException()
            throws SQLException {
        Mockito.when(jobRoleService.getOpenJobRoles())
                .thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles();

        Assert.assertEquals(
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                response.getStatus());
    }

    @Test
    public void getJobRoleById_shouldReturnJobRoleDetailedResponse_whenJobRoleExists()
            throws SQLException, DoesNotExistException {

        int jobRoleId = 1;
        Date closingDate = new Date(System.currentTimeMillis());
        JobRoleDetailedResponse expectedJobRole = new JobRoleDetailedResponse("Software Engineer",
                "Develops, tests, and maintains software applications.",
                "Design, develop, and maintain software applications.",
                "https://sharepoint.com/job/software-engineer", "New York",
                "Software Development", "Senior", closingDate, "Open", 1);

        Mockito.when(jobRoleService.getJobRoleById(jobRoleId))
                .thenReturn(expectedJobRole);

        Response response = jobRoleController.getJobRoleById(jobRoleId);

        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals(expectedJobRole, response.getEntity());
    }

    @Test
    public void getJobRoleById_shouldReturn500_whenServiceThrowsSQLException() throws SQLException, DoesNotExistException {

        int jobRoleId = 1;

        Mockito.when(jobRoleService.getJobRoleById(jobRoleId)).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoleById(jobRoleId);

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void getJobRoleById_shouldReturn404_whenJobRoleDoesNotExist() throws SQLException, DoesNotExistException {

        int jobRoleId = 1;

        Mockito.when(jobRoleService.getJobRoleById(jobRoleId)).thenThrow(DoesNotExistException.class);

        Response response = jobRoleController.getJobRoleById(jobRoleId);

        Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
