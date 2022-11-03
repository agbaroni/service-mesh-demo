package io.github.agbaroni.smdemo.api;

import io.smallrye.mutiny.Uni;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey="service2")
public interface AgencyResource {

    @GET
    Uni<List<Agency>> getAll();

    @GET
    @Path("/{id}")
    Uni<Agency> getOne(@PathParam("id") String id);
}
