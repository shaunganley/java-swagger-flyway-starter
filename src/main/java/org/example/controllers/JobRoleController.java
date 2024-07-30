package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FormatException;
import org.example.exceptions.InvalidException;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Job Roles API")
@Path("/api")

public class JobRoleController {
    final JobRoleService jobRoleService;

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }


    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles() {
        try {
            return Response.ok().entity(jobRoleService.getAllRoles()).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GET
    @Path("/job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoleById(@PathParam("id") final String id) {
        try {
            return Response.ok().entity(
                    jobRoleService.getJobRoleById(id)).build();
        } catch (FormatException e) {
            return Response.status(
                    Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (InvalidException e) {
            return Response.status(
                    Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (DoesNotExistException e) {
            return Response.status(
                    Response.Status.NOT_FOUND).entity(
                    e.getMessage()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
