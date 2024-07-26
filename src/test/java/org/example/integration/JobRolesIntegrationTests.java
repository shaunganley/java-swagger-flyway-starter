package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.JDDApplication;
import org.example.JDDConfiguration;
import org.example.models.JobRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Client;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRolesIntegrationTests {
    public static final DropwizardAppExtension<JDDConfiguration> APP =
            new DropwizardAppExtension<>(JDDApplication.class);

    @Test
    void getJobRoles_shouldReturnListOfJobRoles() {
        Client client = APP.client();

        List<JobRole> response = client
                .target("http://localhost:8080/api/JobRoles")
                .request()
                .get(List.class);

        Assertions.assertFalse(response.isEmpty());

    }
}
