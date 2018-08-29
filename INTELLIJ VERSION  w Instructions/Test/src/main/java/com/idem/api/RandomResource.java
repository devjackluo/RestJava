package com.idem.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("random")
public class RandomResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSample(){

        Random random = new Random();
        random.setMore("more stuff");
        random.setStuff("stuff");

        Random random2 = new Random();
        random2.setMore("more stuff2");
        random2.setStuff("stuff2");

        Randoms randoms = new Randoms();

        List<Random> randomsList = new ArrayList<>();
        randomsList.add(random);
        randomsList.add(random2);

        randoms.setRandoms(randomsList);

        return Response.ok().entity(randoms).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSample(Random random){

        System.out.println("You did it");

        Random random1 = new Random();
        random1.setMore("more stuff");
        random1.setStuff("stuff");

        Random random2 = new Random();
        random2.setMore("more stuff2");
        random2.setStuff("stuff2");

        Randoms randoms = new Randoms();

        List<Random> randomsList = new ArrayList<>();
        randomsList.add(random1);
        randomsList.add(random2);
        randomsList.add(random);

        randoms.setRandoms(randomsList);

        return Response.ok().entity(randoms).build();
    }

}