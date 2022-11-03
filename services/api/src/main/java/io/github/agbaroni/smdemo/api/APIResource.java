package io.github.agbaroni.smdemo.api;

import io.smallrye.mutiny.Uni;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class APIResource implements Serializable {
    private static final long serialVersionUID = 3751269402074020482L;

    @RestClient
    AccountResource accounts;

    @RestClient
    AgencyResource agencies;

    @GET
    public Uni<List<AgencyAccounts>> getAll() {
	return agencies.getAll().onItem().transform(items -> {
		var l = new LinkedList<AgencyAccounts>();

		for (var item : items) {
		    var aa = new AgencyAccounts();

		    aa.setAgency(item.getId());
		    aa.setAccounts(accounts.getAll(item.getId()).await().indefinitely());

		    l.add(aa);
		}

		return l;
	    });
    }
}
