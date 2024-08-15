package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeDetailsRequest;
import org.example.models.DeliveryEmployee;
import org.example.models.SalesEmployee;
import org.example.models.UserRole;
import org.example.services.EmployeeService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
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
    @Produces(MediaType.APPLICATION_JSON)@RolesAllowed({UserRole.ADMIN})
    @ApiOperation(
            value = "Returns All Sales Employees",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = SalesEmployee.class)
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
    @RolesAllowed({UserRole.ADMIN})
    @ApiOperation(
            value = "Returns All Delivery Employees",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = DeliveryEmployee.class)
    public Response getDeliveryEmployees() throws SQLException {
        try {
            return Response.ok().entity(
                    employeeService.getAllDeliveryEmployees()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
    @GET
    @Path("/sales/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN})
    @ApiOperation(
            value = "Returns a Sales Employee",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = SalesEmployee.class)
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
    @Path("/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN})
    @ApiOperation(
            value = "Returns a Delivery Employee",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = DeliveryEmployee.class)
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
    @POST
    @Path("/createDeliveryEmployee")
    public Response createDeliveryEmployee(
            final DeliveryEmployeeDetailsRequest
                    deliveryEmployeeDetailsRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(employeeService.createDeliveryEmployee(
                            deliveryEmployeeDetailsRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
