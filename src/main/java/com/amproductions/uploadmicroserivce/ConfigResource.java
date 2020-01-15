package com.amproductions.uploadmicroserivce;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConfigResource {

    @Inject
    private ConfigProperties properties;

    @GET
    @Path("/config")
    public Response test() {
        String response =
                "{" +
                        "\"width\": \"%d\"," +
                        "\"height\": \"%d\"" +
                        "}";

        response = String.format(
                response,
                properties.getWidth(),
                properties.getHeight());

        return Response.ok(response).build();
    }

    @GET
    @Path("/get")
    public Response get() {
        return Response.ok(ConfigurationUtil.getInstance().get("rest-config.string-property").orElse("nope")).build();
    }
}
