package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.SalesEmpRequest;
import org.example.services.SalesEmpService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Sales Employee API")
@Path("/api/sales-employee")
public class SalesEmpController {
    SalesEmpService salesEmpService;

    public SalesEmpController(SalesEmpService salesEmpService) {
        this.salesEmpService = salesEmpService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmpRequest salesEmpRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(salesEmpService.createSalesEmployee(salesEmpRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            return Response.serverError().build();
        }
    }
}
