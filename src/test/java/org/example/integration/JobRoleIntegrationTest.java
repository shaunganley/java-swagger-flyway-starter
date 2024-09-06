package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.KainosJobWebApplication;
import org.example.KainosJobWebConfiguration;
import org.example.models.JobRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.validation.constraints.Null;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";

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
    public void getJobRoleById_shouldReturnJobRole_whenJobRoleExists() {
        Client client = APP.client();

        Response response = client
                .target(BASE_URL + "/job-roles/1")
                .request()
                .get();

        Assertions.assertNotNull(response);

    }

    @Test
    public void getJobRoleById_shouldReturn404_whenJobRoleDoesNotExist() {
        Client client = APP.client();

        int nonExistentJobRoleId = 9999;

        Response response = client
                .target(BASE_URL + "/job-roles/" + nonExistentJobRoleId)
                .request()
                .get();

        Assertions.assertEquals(404, response.getStatus());
    }

}
