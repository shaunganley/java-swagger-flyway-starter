package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.jsonwebtoken.Jwts;
import org.example.controllers.AuthController;
import org.example.controllers.TestController;
import org.example.daos.AuthDao;
import org.example.daos.TestDao;
import org.example.services.AuthService;
import org.example.services.TestService;

import java.security.Key;

public class KainosWebApplication extends Application<KainosWebConfiguration> {
    public static void main(final String[] args) throws Exception {
        new KainosWebApplication().run(args);
    }
    @Override
    public String getName() {
        return "Test";
    }
    @Override
    public void initialize(final Bootstrap<KainosWebConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final KainosWebConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final KainosWebConfiguration configuration,
                    final Environment environment) {
        Key jwtKey = Jwts.SIG.HS256.key().build();
        environment.jersey()
                .register(new TestController(new TestService(new TestDao())));
        environment.jersey().register(new AuthController(
                new AuthService(new AuthDao(), jwtKey)));
    }

}
