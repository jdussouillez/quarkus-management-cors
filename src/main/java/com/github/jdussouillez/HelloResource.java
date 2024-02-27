package com.github.jdussouillez;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {

    @Inject
    protected HelloService helloService;

    @GET
    @Path("{locale}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello(@PathParam("locale") final String locale) {
        return helloService.hello(locale);
    }

    @POST
    @Path("{locale}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Void> add(@PathParam("locale") final String locale, final String hello) {
        return helloService.add(locale, hello);
    }
}
