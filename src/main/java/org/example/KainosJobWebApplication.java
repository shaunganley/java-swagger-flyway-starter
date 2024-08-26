package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.JobRoleController;
import org.example.daos.JobRoleDao;
import org.example.services.JobRoleService;

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
    public void initialize(
            final Bootstrap<KainosJobWebConfiguration> bootstrap) {
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
        environment.jersey()
                .register(new JobRoleController(
                        new JobRoleService(new JobRoleDao())));
    }

}
