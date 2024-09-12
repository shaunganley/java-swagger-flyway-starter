package org.example;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.jsonwebtoken.Jwts;
import org.example.auth.JwtAuthenticator;
import org.example.auth.RoleAuthoriser;
import org.example.controllers.AuthController;
import org.example.daos.AuthDao;
import org.example.models.JwtToken;
import org.example.services.AuthService;
import org.example.services.JobRoleService;

import java.security.Key;

import org.example.controllers.JobRoleController;
import org.example.daos.JobRoleDao;
import org.example.validators.JobRoleValidator;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;


public class KainosJobWebApplication extends
        Application<KainosJobWebConfiguration> {
    public static void main(final String[] args) throws Exception {
        new KainosJobWebApplication().run(args);
    }

    @Override
    public String getName() {
        return "KainosJobApp";
    }

    @Override
    public void initialize(final Bootstrap
            <KainosJobWebConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final KainosJobWebConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final KainosJobWebConfiguration configuration,
                    final Environment environment) {
        Key jwtKey = Jwts.SIG.HS256.key().build();

        environment.jersey().register(new AuthDynamicFeature(
                new OAuthCredentialAuthFilter.Builder<JwtToken>()
                        .setAuthenticator(new JwtAuthenticator(jwtKey))
                        .setAuthorizer(new RoleAuthoriser())
                        .setPrefix("Bearer")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(
                JwtToken.class));
        environment.jersey().register(new AuthController(
                new AuthService(new AuthDao(), jwtKey)));
        environment.jersey().register(new JobRoleController(
                new JobRoleService(new JobRoleDao(), new JobRoleValidator())));
    }
}
