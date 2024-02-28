package com.github.jdussouillez;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("hello")
public class HelloResource {

    @Inject
    protected HelloService helloService;

    @GET
    @Path("{locale}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(operationId = "hello")
    public Uni<String> hello(@PathParam("locale") final String locale) {
        return helloService.hello(locale);
    }

    @POST
    @Path("{locale}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(operationId = "addHello")
    public Uni<Void> add(@PathParam("locale") final String locale, final String hello) {
        return helloService.add(locale, hello);
    }
}
