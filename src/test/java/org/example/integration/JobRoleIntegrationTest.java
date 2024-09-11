package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.KainosJobWebApplication;
import org.example.KainosJobWebConfiguration;
import org.example.models.JobRole;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.validation.constraints.Null;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";

    private static final DropwizardAppExtension<KainosJobWebConfiguration> APP =
            new DropwizardAppExtension<>(KainosJobWebApplication.class);

    private String loginAndGetToken() {
        System.out.println();
        Client client = APP.client();
        Response response =
                client.target("http://localhost:8080/api/auth/login")
                        .request()
                        .post(Entity.json(new LoginRequest(
                                System.getenv().get("VALID_TEST_EMAIL"),
                                System.getenv().get("VALID_TEST_PASSWORD")
                        )));
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String token = response.readEntity(String.class);
        assertNotNull(token);
        return token;
    }


    @Test
    public void getJobRoles_shouldReturnListOfJobRoles() {
        Client client = APP.client();
        String token = loginAndGetToken();
        List<JobRole> response = client
                .target("http://localhost:8080/api/job-roles")
                .request()
                .header("Authorization", "Bearer " + token)
                .get(List.class);

        Assertions.assertFalse(response.isEmpty());
    }

    @Test
    public void getAllJobRoles_shouldReturn401WhenNoTokenProvided() {
        Client client = APP.client();

        Response response = client.target("http://localhost:8080/api/job-roles")
                .request()
                .get();

        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(),
                response.getStatus());
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
        String token = loginAndGetToken();

        int nonExistentJobRoleId = 9999;

        Response response = client
                .target(BASE_URL + "/job-roles/" + nonExistentJobRoleId)
                .request()
                .header("Authorization", "Bearer " + token)
                .get();

        Assertions.assertEquals(404, response.getStatus());
    }

}
