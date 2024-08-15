package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DoesNotExistException;
import org.example.services.EmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Employee Services API")
@Path("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @Path("/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployees() throws SQLException {
        try {
            return Response.ok().entity(
                    employeeService.getAllSalesEmployees()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployees() throws SQLException {
        try {
            return Response.ok().entity(
                    employeeService.getAllDeliveryEmployees()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
    @GET
    @Path("sales/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployeeById(final @PathParam("id") int id)
        throws SQLException {
        try {
            return Response.ok().entity(
                    employeeService.getSalesEmployeeById(id))
                    .build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
    @GET
    @Path("delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(final @PathParam("id") int id)
            throws SQLException {
        try {
            return Response.ok().entity(
                    employeeService.getDeliveryEmployeeById(id))
                    .build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
