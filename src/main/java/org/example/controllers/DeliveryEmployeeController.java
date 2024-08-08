package org.example.controllers;

import freemarker.core.ReturnInstruction;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

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
            @PathParam("id") int id, DeliveryEmployeeRequest deliveryEmployeeRequest) {
        try {
            deliveryEmployeeService.updateDeliveryEmployee(id, deliveryEmployeeRequest);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
