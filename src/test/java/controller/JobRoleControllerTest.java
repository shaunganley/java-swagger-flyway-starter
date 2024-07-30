package controller;

import org.example.controllers.JobRoleController;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FormatException;
import org.example.exceptions.InvalidException;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class JobRoleControllerTest {

    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController (jobRoleService);

    @Test
    void GetJobRolesShouldReturnJobRoles()
            throws SQLException {
        List<JobRoleResponse> jobRolesList = new ArrayList<>();

        when(jobRoleService.getAllRoles()).thenReturn(jobRolesList);

        Response re = jobRoleController.getAllJobRoles();

        assertEquals(200, re.getStatus());
        assertEquals(jobRolesList, re.getEntity());
    }

    @Test
    void GetJobRoles_ShouldReturn500WhenServiceThrowsSQLException()
            throws SQLException {
        when(jobRoleService.getAllRoles()).thenThrow(SQLException.class);

        Response re = jobRoleController.getAllJobRoles();

        assertEquals(500, re.getStatus());
    }

    JobRole jobRole = new JobRole(
            3,
            "Farmer",
            "higgensburgh",
            "medium",
            "20,000",
            Date.from(Instant.parse("2000-01-01T00:00:00.000Z")),
            "open",
            "farm items",
            "make sure corn picked",
            "very specific"
    );

    @Test
    void getJobRoleById_ShouldReturnJobRole()
            throws SQLException, DoesNotExistException,
            InvalidException, FormatException {
        String id = "3";
        when(jobRoleService.getJobRoleById(id)).thenReturn(jobRole);

        Response re = jobRoleController.getJobRoleById(id);

        assertEquals(200, re.getStatus());
        assertEquals(jobRole, re.getEntity());
    }

    @Test
    void getJobRoleById_ShouldReturn400WhenServiceThrowsFormatException()
            throws SQLException, DoesNotExistException,
            InvalidException, FormatException {
        String id = "sdfhkjsd";
        when(jobRoleService.getJobRoleById(id)).thenThrow(FormatException.class);

        Response re = jobRoleController.getJobRoleById(id);

        assertEquals(400, re.getStatus());
    }

    @Test
    void getJobRoleById_ShouldReturn400WhenServiceThrowsInvalidException()
            throws SQLException, DoesNotExistException,
            InvalidException, FormatException {
        String id = "-6";
        when(jobRoleService.getJobRoleById(id)).thenThrow(InvalidException.class);

        Response re = jobRoleController.getJobRoleById(id);

        assertEquals(400, re.getStatus());
    }

    @Test
    void getJobRoleById_ShouldReturn404WhenServiceThrowsDoesNotExistException()
            throws SQLException, DoesNotExistException,
            InvalidException, FormatException {
        String id = "2000";
        when(jobRoleService.getJobRoleById(id)).thenThrow(DoesNotExistException.class);

        Response re = jobRoleController.getJobRoleById(id);

        assertEquals(404, re.getStatus());
    }

    @Test
    void getJobRoleById_ShouldReturn500WhenServiceThrowsSQLException()
            throws SQLException, DoesNotExistException,
            InvalidException, FormatException {
        String id = "1";
        when(jobRoleService.getJobRoleById(id)).thenThrow(SQLException.class);

        Response re = jobRoleController.getJobRoleById(id);

        assertEquals(500, re.getStatus());
    }
}
