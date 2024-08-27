package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TestConfiguration extends Configuration {
    @Valid
    @NotNull
    private final SwaggerBundleConfiguration swagger =
            new SwaggerBundleConfiguration();
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration getSwagger() {
        swagger.setResourcePackage("org.example.controllers");
        String[] schemes = {"http", "https"};
        swagger.setSchemes(schemes);
        swagger.setTitle("GoodDayOrg");
        swagger.setDescription("Internal application that assist looking for"
                + " dream job role in company");
        swagger.setVersion("0.0.1");
        swagger.setContact("Johnny Goodday");
        swagger.setContactEmail("info@goodday.org");
        return swagger;
    }
}
