package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleApplication;
import org.example.models.JobRoleResponse;
import org.example.services.JobRoleService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static org.example.util.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.example.util.HttpStatus.NOT_FOUND;
import static org.example.util.HttpStatus.OK;


@Api("Job Role API")
@Path("/api/job-roles")
public class JobRoleController {
    JobRoleService jobRoleService;
    private static final Logger LOGGER = LogManager.getLogger();

    public JobRoleController(final JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
        LOGGER.info("JobController initialized");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns a list of Job Roles",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = JobRoleResponse.class,
            responseContainer = "List",
            produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = OK, message = "Job roles listed successfully", response = JobRole.class),
            @ApiResponse(code = INTERNAL_SERVER_ERROR, message = "getAllJobRoles failed, SQL Exception"),
            @ApiResponse(code = NOT_FOUND, message = "getAllJobRoles failed, DoesNotExistException")
    })
    public Response getAllJobRoles() {
        LOGGER.info("Get all job roles request received");
        try {
            return Response.ok().entity(jobRoleService.getAllJobRoles()).build();
        } catch (SQLException e) {
            LOGGER.error("getAllJobRoles failed, SQL Exception\n" + e.getMessage());
            return Response.serverError().build();
        } catch (DoesNotExistException | NullPointerException e) {
            LOGGER.error("getAllJobRoles failed, DoesNotExistException\n" + e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (ResultSetException e) {
            LOGGER.error("getAllJobRoles failed, ResultSetException\n" + e.getMessage());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/applications/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns a list of user's applications",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = JobRoleApplication.class,
            responseContainer = "List",
            produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = OK, message = "Job roles listed successfully", response = JobRoleApplication.class),
            @ApiResponse(code = INTERNAL_SERVER_ERROR, message = "getUserAllJobApplications failed, SQL Exception"),
            @ApiResponse(code = NOT_FOUND, message = "getUserAllJobApplications failed, DoesNotExistException")
    })
    public Response getUserAllJobApplications(@PathParam("id") int userId) {
        LOGGER.info("Get all user job applications request received");
        try {
            return Response.ok().entity(jobRoleService.getAllUserApplications(userId)).build();
        } catch(SQLException e) {
            LOGGER.error("getUserAllJobApplications failed, SQLException\n" + e.getMessage());
            return Response.serverError().build();
        } catch (DoesNotExistException e) {
            LOGGER.error("getUserAllJobApplications failed, DoesNotExistException\n" + e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
