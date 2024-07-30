package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.JDDApplication;
import org.example.JDDConfiguration;
import org.example.models.JobRole;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRolesIntegrationTests {
    public static final DropwizardAppExtension<JDDConfiguration> APP =
            new DropwizardAppExtension<>(JDDApplication.class);

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
    void getJobRoles_shouldReturn200_WhenUserIsAuthorised() {
        Client client = APP.client();
        int response = client
                .target("http://localhost:8080/api/JobRoles")
                .request().post(Entity.json(loginRequest))
                .getStatus();
        Assertions.assertEquals(200,response);
    }

}
