package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.models.JobRoleResponse;
import org.example.models.UserRole;
import org.eclipse.jetty.http.HttpStatus;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.InvalidException;
import org.example.models.JobRoleRequest;
import org.example.services.JobRoleService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api("Kainos Job Application - Job Roles API")
@Path("/api")
public class JobRoleController {
    private final JobRoleService jobRoleService;

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Returns all job roles with status open",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = JobRoleResponse.class)
    public Response getJobRoles(final @QueryParam("orderBy") String orderBy,
                                final @QueryParam(
                                        "direction") String direction)
            throws SQLException {
        try {
            List<JobRoleResponse> roles =
                    jobRoleService.getOpenJobRoles(orderBy, direction);
            return Response.ok().entity(roles).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Returns job role by id",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = JobRoleResponse.class)
    public Response getJobRoleById(final @PathParam("id") int id)
            throws SQLException {
        try {
            return Response.ok().entity(
                    jobRoleService.getJobRoleById(id)).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (DoesNotExistException e) {
            return Response.status(HttpStatus.NOT_FOUND_404).build();
        }
    }

    @POST
    @Path("/job-roles")
    @RolesAllowed({UserRole.ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a job role - admin only",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = JobRoleResponse.class)
    public Response createJobRole(final JobRoleRequest jobRoleRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(jobRoleService.createJobRole(jobRoleRequest))
                    .build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(
                    Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
