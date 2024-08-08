package org.example.controllers;

import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;
import org.example.services.SalesEmployeeService;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class SalesEmployeeController {

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSalesEmployee(
            @PathParam("id") final int id,
            final SalesEmployeeRequest salesEmployeeRequest) {
        try {
            SalesEmployeeService.updateSalesEmployee(id, salesEmployeeRequest);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
    }
}
