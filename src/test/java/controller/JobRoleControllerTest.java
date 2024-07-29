package controller;

import org.example.controllers.JobRoleController;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class JobRoleControllerTest {

    JobRoleService jobRoleService = Mockito.mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController (jobRoleService);

    @Test
    void GetJobRolesShouldReturnJobRoles() throws SQLException {
        List<JobRoleResponse> jobRolesList = new ArrayList<>();

        when(jobRoleService.getAllRoles()).thenReturn(jobRolesList);

        Response re = jobRoleController.getAllJobRoles();

        assertEquals(200, re.getStatus());
        assertEquals(jobRolesList, re.getEntity());
    }

    @Test
    void GetJobRolesShouldReturn500WhenServiceThrowsSQLException() throws SQLException {
        List<JobRole> jobRolesList = new ArrayList<>();

        when(jobRoleService.getAllRoles()).thenThrow(SQLException.class);

        Response re = jobRoleController.getAllJobRoles();

        assertEquals(500, re.getStatus());
    }

}
