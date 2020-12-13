package com.redhat.openshift.streaming.qute;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("/")
public class IndexPage {

    @Inject
    Template index;

    @ConfigProperty(name = "environment", defaultValue = "dev")
    String environment;

    @ConfigProperty(name = "message", defaultValue = "")
    Optional<String> message;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        String backgroundColor;

        switch (environment.toLowerCase()) {
            case "prod":
                backgroundColor = Color.RED.toHex();
                break;
            default:
                backgroundColor = Color.BLUE.toHex();
        }

        return index.data("background_color", backgroundColor).data("message", message.orElse(""));
    }

}
