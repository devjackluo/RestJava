package com.idem.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("idemresource")
public class IdemResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSample(){
        return "Hello World";
    }

}
