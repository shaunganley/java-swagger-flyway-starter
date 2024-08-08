package org.example.controllers;

import org.example.services.DeliveryProjectService;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class DeliveryProjectController {

    DeliveryProjectService deliveryProjectService;

    public DeliveryProjectController(
            final DeliveryProjectService deliveryProjectService) {
        this.deliveryProjectService = deliveryProjectService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response
    getProjectDetails() {
        try {
            return Response.ok()
                    .entity(deliveryProjectService.getProjectDetails()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
