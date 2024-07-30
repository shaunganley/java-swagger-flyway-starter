package org.example.integration;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.example.JDDApplication;
import org.example.JDDConfiguration;
import org.example.models.JobRole;
import org.example.models.JobRoleInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
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
}
