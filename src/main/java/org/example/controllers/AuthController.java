package org.example.controllers;

import io.swagger.annotations.*;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.UserRole;
import org.example.services.AuthService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Api("Engineering Academy Dropwizard Auth API")
@Path("/api/auth")
@SwaggerDefinition(
        securityDefinition = @SecurityDefinition(
                apiKeyAuthDefinitions = {
                        @ApiKeyAuthDefinition(
                                key = HttpHeaders.AUTHORIZATION,
                                name = HttpHeaders.AUTHORIZATION,
                                in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER
                        )
                }
        )
)

public class AuthController {

    AuthService authService;

    private static final Logger LOGGER = LogManager.getLogger();

    public AuthController(final AuthService authService) {
        this.authService = authService;

        LOGGER.info("Authcontroller has been initialized");

    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(final LoginRequest loginRequest) {
        LOGGER.info("Login request received");
        try {
            return Response.ok().entity(authService
                    .login(loginRequest)).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            LOGGER.error("Login request failed ", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/fake1")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.USER})
    @ApiOperation(
            value = "Reaturns fake1 - user & admin",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Response.class
    )
    public Response Fake1() {
        return Response.ok().entity("fake 1").build();
    }

    @GET
    @Path("/fake2")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.USER})
    @ApiOperation(
            value = "Reaturns fake2 - only user",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Response.class
    )
    public Response Fake2() {
        return Response.ok().entity("fake2").build();
    }

}
