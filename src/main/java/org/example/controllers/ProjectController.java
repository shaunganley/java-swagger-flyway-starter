package org.example.controllers;

import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.CompletedProjectRequest;
import org.example.services.ProjectService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class ProjectController {

    ProjectService projectService;

    @GET
    @Path("/{projectId}, /{deliveryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompletedProject(
            @PathParam("projectId") final int projectId,
            @PathParam("deliveryId") final int deliveryId,
            final CompletedProjectRequest completedProjectRequest) {
        try {
            return Response.ok()
                    .entity(projectService.createCompletedProject(projectId,
                            deliveryId, completedProjectRequest)).build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (FailedToCreateException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
