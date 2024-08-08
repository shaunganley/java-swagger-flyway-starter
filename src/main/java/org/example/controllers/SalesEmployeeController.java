package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.services.SalesEmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Delivery Employee API")
@Path("/api/SalesEmployees")
public class SalesEmployeeController {
    SalesEmployeeService salesEmployeeService;

    public SalesEmployeeController(
            final SalesEmployeeService salesEmployeeService) {
        this.salesEmployeeService = salesEmployeeService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testConnection() {
        try {
            return Response.ok()
                    .entity(salesEmployeeService.getAllSalesEmployees())
                    .build();
        } catch (SQLException e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }
}
