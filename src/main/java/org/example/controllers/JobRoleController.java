package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DatabaseConnectionException;
import org.example.models.JobRole;
import org.example.models.JobRoleInfo;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Api("Job Roles")
@Path("/api/JobRoles")
public class JobRoleController {

    private static final Logger LOGGER = Logger.getLogger(JobRoleController.class.getName());

    final JobRoleService jobRoleService;

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoles() {
        try {
            List<JobRole> jobRoles = jobRoleService.getJobRoles();
            return Response.ok().entity(jobRoles).build();
        } catch (SQLException | DatabaseConnectionException e) {
            LOGGER.log(Level.SEVERE, "Error getting job roles", e);
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoleById(final @PathParam("id") int id) {
        try {
            JobRoleInfo jobRoleInfo = jobRoleService.getJobRoleById(id);
            if (jobRoleInfo != null) {
                return Response.ok().entity(jobRoleInfo).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException | DatabaseConnectionException e) {
            LOGGER.log(Level.SEVERE, "Error getting job role by id: " + id, e);
            return Response.serverError().build();
        }
    }
}
