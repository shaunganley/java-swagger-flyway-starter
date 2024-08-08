package org.example.controllers;
import io.swagger.annotations.Api;
import org.example.services.EmployeeService;
import org.example.models.EmployeeRequest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        return Response.ok().entity(employeeService.getAllEmployees()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") int id)
            throws SQLException {
        return Response.ok().entity(employeeService.getEmployeeById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(
            @PathParam("id") int id, EmployeeRequest employeeRequest) {
        try {
            employeeService.updateEmployee(id, employeeRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    )

}
