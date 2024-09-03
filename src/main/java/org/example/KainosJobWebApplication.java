package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
<<<<<<<< HEAD:src/main/java/org/example/KainosWebApplication.java
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
========
import org.example.controllers.JobRoleController;
import org.example.daos.JobRoleDao;
import org.example.services.JobRoleService;

public class KainosJobWebApplication extends
        Application<KainosJobWebConfiguration> {
    public static void main(final String[] args) throws Exception {
        new KainosJobWebApplication().run(args);
>>>>>>>> origin/main:src/main/java/org/example/KainosJobWebApplication.java
    }
    @Override
    public String getName() {
        return "KainosJobApp";
    }
    @Override
<<<<<<<< HEAD:src/main/java/org/example/KainosWebApplication.java
    public void initialize(final Bootstrap<KainosWebConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final KainosWebConfiguration configuration) {
========
    public void initialize(
            final Bootstrap<KainosJobWebConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final KainosJobWebConfiguration configuration) {
>>>>>>>> origin/main:src/main/java/org/example/KainosJobWebApplication.java
                return configuration.getSwagger();
            }
        });
    }
    @Override
<<<<<<<< HEAD:src/main/java/org/example/KainosWebApplication.java
    public void run(final KainosWebConfiguration configuration,
========
    public void run(final KainosJobWebConfiguration configuration,
>>>>>>>> origin/main:src/main/java/org/example/KainosJobWebApplication.java
                    final Environment environment) {
        Key jwtKey = Jwts.SIG.HS256.key().build();
        environment.jersey()
<<<<<<<< HEAD:src/main/java/org/example/KainosWebApplication.java
                .register(new TestController(new TestService(new TestDao())));
        environment.jersey().register(new AuthController(
                new AuthService(new AuthDao(), jwtKey)));
========
                .register(new JobRoleController(
                        new JobRoleService(new JobRoleDao())));
>>>>>>>> origin/main:src/main/java/org/example/KainosJobWebApplication.java
    }

}
