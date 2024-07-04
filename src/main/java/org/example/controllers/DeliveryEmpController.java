package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.DeliveryEmpRequest;
import org.example.services.DeliveryEmpService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Delivery Employee API")
@Path("/api/delivery-employee")
public class DeliveryEmpController {
    DeliveryEmpService deliveryEmpService;

    public DeliveryEmpController(DeliveryEmpService deliveryEmpService) {
        this.deliveryEmpService = deliveryEmpService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmpRequest deliveryEmpRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(deliveryEmpService.createDeliveryEmployee(deliveryEmpRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            return Response.serverError().build();
        }
    }
}