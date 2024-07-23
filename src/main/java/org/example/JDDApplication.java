package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.JobRoleController;
import org.example.daos.JobRoleDao;
import org.example.services.JobRoleService;

public class JDDApplication extends Application<JDDConfiguration> {
    public static void main(final String[] args) throws Exception {
        new JDDApplication().run(args);
    }
    @Override
    public String getName() {
        return "JDD";
    }
    @Override
    public void initialize(final Bootstrap<JDDConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final JDDConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final JDDConfiguration configuration,
                    final Environment environment) {
        environment.jersey()
                .register(
                        new JobRoleController(
                                new JobRoleService(
                                        new JobRoleDao())));
    }

}
