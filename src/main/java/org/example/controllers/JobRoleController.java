package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Api
@Path("/api/JobRoles")
public class JobRoleController {

    final JobRoleService jobRoleService;

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoles() {
        try {
            List<JobRole> jobRoles = jobRoleService.getJobRoles();
            List<JobRoleResponse> response = jobRoles.stream()
                    .map(jobRole -> new JobRoleResponse(
                            jobRole.getId(),
                            jobRole.getRoleName(),
                            jobRole.getLocation(),
                            jobRole.getCapability(),
                            jobRole.getBand(),
                            jobRole.getClosingDate()))
                    .collect(Collectors.toList());
            return Response.ok().entity(response).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
