package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.JDDApplication;
import org.example.JDDConfiguration;
import org.example.models.JobRole;
import org.example.models.JobRoleInfo;
import org.example.models.LoginRequest;

import org.example.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;


import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;


@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRolesIntegrationTests {
    public static final DropwizardAppExtension<JDDConfiguration> APP =
            new DropwizardAppExtension<>(JDDApplication.class);
    AuthService authService = Mockito.mock(AuthService.class);
    private static final String EMAIL   = System.getenv("LOGIN_EMAIL_1");
    private static final String PASSWORD  = System.getenv("LOGIN_PASSWORD_1");

    private static final LoginRequest loginRequest = new LoginRequest(
            EMAIL,
            PASSWORD
    );


    @Test
    void getJobRoles_shouldReturn401Unauthorised_WhenUserNotLoggedIn() {
        Client client = APP.client();

        int response = client
                .target("http://localhost:8080/api/JobRoles")
                .request()
                .get().getStatus();

        Assertions.assertEquals(401, response);

    }
    @Test
    void getJobRoleById_shouldReturnJobRoleInfo_whenJobRoleInfoDoesExist(){
        Client client = APP.client();
        Response response = client
                .target("http://localhost:8080/api/JobRoles/1")
                .request()
                .get();

        JobRoleInfo jobRoleInfo = response.readEntity(JobRoleInfo.class);

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(1, jobRoleInfo.getId());
    }
    @Test
    void getJobRoleById_shouldReturn404_whenJobRoleInfoDoesNotExist(){
        Client client = APP.client();
        Response response = client
                .target("http://localhost:8080/api/JobRoles/99999")
                .request()
                .get();

        Assertions.assertEquals(404, response.getStatus());
    }

    @Test
    void getJobRoles_shouldReturn200_WhenUserIsAuthorised() {
        Client client = APP.client();

        Response token = client
                .target("http://localhost:8080/api/auth/login")
                .request().post(Entity.json(loginRequest));

        int response = client
                .target("http://localhost:8080/api/JobRoles")
                .request().header("Authorization", "Bearer "
                        + token.readEntity(String.class)).get()
                .getStatus();
        Assertions.assertEquals(200,response);
    }

}
