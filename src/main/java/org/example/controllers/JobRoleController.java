package org.example.controllers;

import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FileUploadException;
import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.models.JwtToken;
import org.example.models.RoleApplicationResponse;
import org.example.models.UserRole;
import org.example.services.JobRoleService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.annotation.security.RolesAllowed;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URISyntaxException;
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
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @RolesAllowed({UserRole.USER})
    @ApiOperation(
            value = "Inform user if cv was sent successfully",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = RoleApplicationResponse.class,
            produces = "application/json")
    @Path("/{jobRoleId}/applications")
    public Response applyForRole(@PathParam("jobRoleId")final int jobRoleId,
                                 @FormDataParam("file") final InputStream fileInputStream,
                                 @FormDataParam("file") final FormDataContentDisposition fileDetail,
                                 @ApiParam(hidden = true) @Auth final JwtToken token) {
        String userEmail = token.getUserEmail();

        try {
            jobRoleService.applyForRole(jobRoleId, userEmail, fileInputStream, fileDetail);
        }catch (FileUploadException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return Response.ok().entity(new RoleApplicationResponse("File uploaded successfully")).build();
        //return Response.ok().entity(new RoleApplicationResponse("success with email: " + userEmail)).build();
    }
}
