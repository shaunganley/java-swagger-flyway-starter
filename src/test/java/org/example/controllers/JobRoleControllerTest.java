package org.example.controllers;

import org.example.enums.Direction;
import org.example.enums.JobRoleColumn;
import org.example.exceptions.DoesNotExistException;
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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobRoleControllerTest {

    JobRoleResponse jobRole1 = new JobRoleResponse(
            101,
            "Software Engineer",
            "Belfast",
            "Engineering",
            "Senior",
            new Date(2024 - 1900, 11, 30)
    );

    // Hard-coded JobRoleResponse 2
    JobRoleResponse jobRole2 = new JobRoleResponse(
            102,
            "Data Analyst",
            "London",
            "Data & Insights",
            "Mid-Level",
            new Date(2024 - 1900, 10, 15)
    );;

    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);

    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    public void getJobRoles_shouldReturnResponseCode200WithJobRoleResponses_whenNoErrorsThrown()
            throws SQLException {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleResponse jobRoleResponse = new JobRoleResponse(1,"SE", "Derry",
                "Eng", "Band 4", closingDate);

        List<JobRoleResponse> jobRoleResponses = new ArrayList<>();
        jobRoleResponses.add(jobRoleResponse);

        Response expectedResponse =
                Response.ok().entity(jobRoleResponses).build();

        when(jobRoleService.getOpenJobRoles(null, null))
                .thenReturn(jobRoleResponses);

        Response actualResponse =
                Response.ok().entity(jobRoleService.getOpenJobRoles(null, null)).build();

        Assert.assertEquals(expectedResponse.getStatus(),
                actualResponse.getStatus());

        Assert.assertEquals(expectedResponse.getEntity(),
                actualResponse.getEntity());
    }

    @Test
    public void getJobRoles_shouldReturnResponseCode500_whenServiceThrowsSqlException()
            throws SQLException {
        when(jobRoleService.getOpenJobRoles(null, null))
                .thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoles(null, null);

        Assert.assertEquals(
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                response.getStatus());
    }

    @Test
    public void getJobRoleById_shouldReturnJobRoleDetailedResponse_whenJobRoleExists()
            throws SQLException, DoesNotExistException {

        int jobRoleId = 1;
        Date closingDate = new Date(System.currentTimeMillis());
        JobRoleDetailedResponse expectedJobRole = new JobRoleDetailedResponse(1, "Software Engineer",
                "Develops, tests, and maintains software applications.",
                "Design, develop, and maintain software applications.",
                "https://sharepoint.com/job/software-engineer", "New York",
                "Software Development", "Senior", closingDate, "Open", 1);

        when(jobRoleService.getJobRoleById(jobRoleId))
                .thenReturn(expectedJobRole);

        Response response = jobRoleController.getJobRoleById(jobRoleId);

        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals(expectedJobRole, response.getEntity());
    }

    @Test
    public void getJobRoleById_shouldReturn500_whenServiceThrowsSQLException() throws SQLException, DoesNotExistException {

        int jobRoleId = 1;

        when(jobRoleService.getJobRoleById(jobRoleId)).thenThrow(SQLException.class);

        Response response = jobRoleController.getJobRoleById(jobRoleId);

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void getJobRoleById_shouldReturn404_whenJobRoleDoesNotExist() throws SQLException, DoesNotExistException {

        int jobRoleId = 1;

        when(jobRoleService.getJobRoleById(jobRoleId)).thenThrow(DoesNotExistException.class);

        Response response = jobRoleController.getJobRoleById(jobRoleId);

        Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
    @Test
    public void getJobRoles_withOrdering_shouldReturnOrderedJobRoles() throws SQLException{
        List<JobRoleResponse> roles = Arrays.asList(jobRole1, jobRole2);
        when(jobRoleService.getOpenJobRoles(JobRoleColumn.ROLENAME.getColumnName(), Direction.ASC.getDirectionName())).thenReturn(roles);
        Response response = jobRoleController.getJobRoles(JobRoleColumn.ROLENAME.getColumnName(), Direction.ASC.getDirectionName());
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertFalse(((List<JobRoleResponse>) response.getEntity()).isEmpty());
        assertEquals(roles, response.getEntity());
    }

    @Test
    public void getJobRoles_withOrdering_shouldReturnInternalServerError_whenSQLExceptionThrown() throws SQLException{
        when(jobRoleService.getOpenJobRoles(JobRoleColumn.ROLENAME.getColumnName(), Direction.ASC.getDirectionName())).thenThrow(SQLException.class);
        Response response = jobRoleController.getJobRoles(JobRoleColumn.ROLENAME.getColumnName(), Direction.ASC.getDirectionName());
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

}
