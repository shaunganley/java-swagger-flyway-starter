package org.example.controllers;

import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;
import org.example.exceptions.DoesNotExistException;
import org.example.services.JobRoleService;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Kainos Job Application - Job Roles API")
@Path("/api")
public class JobRoleController {
    private JobRoleService jobRoleService;

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoles(final @QueryParam("sort") String sort)
            throws SQLException {
        if (sort == null) {
            try {
                return Response.ok().entity(
                        jobRoleService.getOpenJobRoles()).build();
            } catch (SQLException e) {
                return Response.serverError().build();
            }
        } else {
            try {
                String[] sortParts = sort.split(":");
                String field = sortParts[0];
                String direction = sortParts[1];
                direction = direction.toUpperCase();
                if (direction.equals("DESC") || direction.equals("ASC")) {
                    System.out.println(
                            "Field = " + field + " Direction= " + direction);
                    return Response.ok().entity(
                            jobRoleService.getSortedOpenJobRoles(
                                    field, direction)).build();
                } else {
                    throw new BadRequestException("incorrect query param");
                }
            } catch (SQLException e) {
                return Response.serverError().build();
        }
        }
    }

    @GET
    @Path("/job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
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
}
