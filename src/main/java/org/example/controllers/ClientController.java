package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.requests.ClientRequest;
import org.example.services.ClientService;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Client API")
@Path("/api/client")
public class ClientController {
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient(ClientRequest clientRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(clientService.createClient(clientRequest))
                    .build();
        } catch (SQLException | FailedToCreateException e) {
            return Response.serverError().build();
        }
    }
}
