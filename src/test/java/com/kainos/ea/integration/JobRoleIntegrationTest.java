package com.kainos.ea.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.KainosJobWebApplication;
import org.example.KainosJobWebConfiguration;
import org.example.controllers.JobRoleController;
import org.example.models.JobRole;
import org.example.services.JobRoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleIntegrationTest {

    private static final DropwizardAppExtension<KainosJobWebConfiguration> APP =
            new DropwizardAppExtension<>(KainosJobWebApplication.class);

    @Test
    public void getJobRoles_shouldReturnListOfJobRoles() {
        Client client = APP.client();

        List<JobRole> response = client
                .target("http://localhost:8080/api/job-roles")
                .request()
                .get(List.class);

        Assertions.assertFalse(response.isEmpty());
    }

    @Test
    void getJobRoles_shouldReturnResponseCode500_whenSqlExceptionIsCaught()
            throws SQLException {

        // Create a mock instance of JobRoleService
        JobRoleService mockJobRoleService = Mockito.mock(JobRoleService.class);

        // Configure the mock to throw an SQLException when getAllJobRoles is called
        Mockito.when(mockJobRoleService.getAllJobRoles()).thenThrow(new SQLException("Simulated database error"));

        // Use the mock service in the controller
        JobRoleController jobRoleController = new JobRoleController(mockJobRoleService);

        // Use the client provided by the DropwizardAppExtension
        Client client = APP.client();

        // Make a GET request to the endpoint
        Response response = client
                .target(String.format("http://localhost:8080/api/job-roles"))
                .request()
                .get();

        // Verify that the server returns a 500 Internal Server Error
        Assertions.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());

    }


}
