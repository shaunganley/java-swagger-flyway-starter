package org.example.controllers;

import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;
import org.example.services.DeliveryEmployeeService;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class DeliveryEmployeeController {

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(
            @PathParam("id") final int id,
            final DeliveryEmployeeRequest deliveryEmployeeRequest) {
        try {
            DeliveryEmployeeService.updateDeliveryEmployee(id,
                    deliveryEmployeeRequest);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
    }
}
