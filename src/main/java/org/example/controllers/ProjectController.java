package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.ProjectRequest;
import org.example.services.ProjectService;
import org.example.services.TestService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Project API")
@Path("/api/project")
public class ProjectController {
    ProjectService projectService;
    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(ProjectRequest projectRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(projectService.createProject(projectRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            return Response.serverError().build();
        }
    }
}
