package io.github.agbaroni.smdemo.api;

import io.smallrye.mutiny.Uni;

import java.util.List;

import javax.inject.Inject;
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
@RegisterRestClient(configKey="service1")
public interface AccountResource {

    @GET
    @Path("/{agency}")
    Uni<List<Account>> getAll(@PathParam("agency") String agency);

    @GET
    @Path("/{user}/{account}")
    Uni<Account> getOne(@PathParam("user") String user, @PathParam("account") String account);
}
