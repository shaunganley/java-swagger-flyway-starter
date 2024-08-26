package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Kainos Job Application - Job Roles API")
@Path("/api/")
public class JobRoleController {
    private JobRoleService jobRoleService;

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoles() throws SQLException {
        try {
            return Response.ok().entity(
                    jobRoleService.getAllJobRoles()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
