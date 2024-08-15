package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.models.Client;
import org.example.models.UserRole;
import org.example.services.ClientService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Client API")
@Path("/api/clients")
public class ClientController {

    ClientService clientService;

    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Returns Clients",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Client.class)
    public Response
    getClients() {
        try {
            return Response.ok().entity(clientService.getAllClients()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
