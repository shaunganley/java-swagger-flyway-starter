package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.SalesEmployeeRequest;
import org.example.services.SalesEmployeeService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Sales Employee API")
@Path("/api/sales-employee")
public class SalesEmployeeController {
    SalesEmployeeService salesEmployeeService;

    public SalesEmployeeController(SalesEmployeeService salesEmployeeService) {
        this.salesEmployeeService = salesEmployeeService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(salesEmployeeService.createSalesEmployee(salesEmployeeRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            return Response.serverError().build();
        }
    }
}
