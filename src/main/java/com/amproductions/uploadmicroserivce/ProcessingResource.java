package com.amproductions.uploadmicroserivce;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("processing")
public class ProcessingResource {

    @Inject
    private ConfigProperties properties;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response processImage(String image, @QueryParam("maxHeight") String maxHeight, @QueryParam("maxWidth") String maxWidth) {
        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(image);
        }
        catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        int mw;
        int mh;
        try {
            mw = Integer.parseInt(maxWidth);
            mh = Integer.parseInt(maxHeight);
        } catch (NumberFormatException e){
            mw = 0;
            mh = 0;
        }
        byte[] processed;
        if (mw > 0 && mh > 0){
            processed = ImageTool.processImage(decoded, mw, mh);
        }
        else{
            processed = ImageTool.processImage(decoded, properties.getWidth(), properties.getHeight());
        }
        if(processed == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(Base64.getEncoder().encode(processed)).build();
    }
}
