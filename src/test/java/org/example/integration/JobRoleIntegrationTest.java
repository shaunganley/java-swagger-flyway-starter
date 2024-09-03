package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.KainosJobWebApplication;
import org.example.KainosJobWebConfiguration;
import org.example.models.JobRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Client;
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
}
