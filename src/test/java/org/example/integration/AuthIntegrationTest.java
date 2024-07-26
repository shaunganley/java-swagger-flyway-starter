package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.TestApplication;
import org.example.TestConfiguration;
import org.example.models.LoginRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthIntegrationTest {
    private static final DropwizardAppExtension<TestConfiguration> APP =
            new DropwizardAppExtension<>(TestApplication.class);

    private static final String EMAIL   = System.getenv("LOGIN_EMAIL_1");
    private static final String PASSWORD  = System.getenv("LOGIN_PASSWORD_1");

    @Test
    void login_shouldLogUserIn() {
        LoginRequest loginRequest = new LoginRequest(
                EMAIL,
                PASSWORD
        );
        LoginRequest loginRequest2 = new LoginRequest(
                "notreal@random.com",
                "password321"
        );
        Client client = APP.client();
        int status = client
                .target("http://localhost:8080/api/auth/login")
                .request().post(Entity.json(loginRequest))
                .getStatus();
        Assertions.assertEquals(200,status);

    }

    @Test
    void login_Return404Error(){
        LoginRequest loginRequest = new LoginRequest(
                "notreal@random.com",
                "password321"
        );
        Client client = APP.client();
        int status = client
                .target("http://localhost:8080/api/auth/login")
                .request().post(Entity.json(loginRequest))
                .getStatus();
        Assertions.assertEquals(404, status);
    }

    @Test
    void login_Return400Error(){
        LoginRequest loginRequest = new LoginRequest(
                "adam@random.com",
                "invalidPassword"
        );
        Client client = APP.client();
        int status = client
                .target("http://localhost:8080/api/auth/login")
                .request().post(Entity.json(loginRequest))
                .getStatus();
        Assertions.assertEquals(400, status);
    }
}
