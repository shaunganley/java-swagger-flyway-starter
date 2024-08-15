package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import org.example.controllers.ClientController;
import org.example.controllers.ProjectController;
import org.example.controllers.TestController;
import org.example.daos.ClientDao;
import org.example.daos.ProjectDao;
import org.example.daos.TestDao;
import org.example.services.ClientService;

import org.example.controllers.EmployeeController;
import org.example.daos.EmployeeDao;
import org.example.services.EmployeeService;

import org.example.services.ProjectService;
import org.example.services.TestService;
import org.example.validators.ProjectValidator;


public class TestApplication
        extends Application<TestConfiguration> {
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }
    @Override
    public String getName() {
        return "Git and Run";
    }

    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(
                new SwaggerBundle<TestConfiguration>() {
                    @Override
                    protected SwaggerBundleConfiguration
                    getSwaggerBundleConfiguration(
                            final TestConfiguration
                                    configuration) {
                        return configuration.getSwagger();
                    }
                });
            }

    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {
        environment.jersey()
                .register(new TestController(new TestService(new TestDao())));
        environment.jersey()
                .register(new ClientController(
                        new ClientService(new ClientDao())));
        environment.jersey()
                .register(new EmployeeController(
                        new EmployeeService(new EmployeeDao())));
        environment.jersey()
                .register(new ProjectController(
                        new ProjectService(new ProjectDao(),
                                new ProjectValidator())));
    }

}
