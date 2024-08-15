package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.Project;
import org.example.models.ProjectDetailsRequest;
import org.example.models.SalesEmployee;
import org.example.models.UserRole;
import org.example.services.ProjectService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Project API")
@Path("/api/projects")
public class ProjectController {

    ProjectService projectService;

    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/highestValue")
    @RolesAllowed({UserRole.ADMIN})
    @ApiOperation(
            value = "Returns Highest Value Project",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Project.class)
    public Response
    getHighestValueProject() {
        try {
            return Response.ok().entity(projectService
                    .getHighestValueProject()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createProject")
    @RolesAllowed({UserRole.ADMIN})
    @ApiOperation(
            value = "Create Project",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Project.class)
    public Response createProject(
            final ProjectDetailsRequest projectDetailsRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(projectService.createProject(projectDetailsRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
