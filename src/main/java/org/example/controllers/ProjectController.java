package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.CompletedProjectRequest;
import org.example.services.ProjectService;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy Dropwizard Projects API")
@Path("/api/projects")
public class ProjectController {

    ProjectService projectService;

    @PUT
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
