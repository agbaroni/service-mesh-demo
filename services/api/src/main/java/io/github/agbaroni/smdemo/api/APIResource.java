package io.github.agbaroni.smdemo.api;

import io.smallrye.common.annotation.Blocking;
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

    @Blocking
    @GET
    public Uni<List<AgencyAccounts>> getAll() {
	var allAgencyAccounts = new LinkedList<AgencyAccounts>();
	var allAgencies = agencies.getAll().await().indefinitely();

	if (allAgencies != null) {
	    for (var agency : allAgencies) {
		var allAccounts = accounts.getAll(agency.getId()).await().indefinitely();
		var agencyAccounts = new AgencyAccounts();
		var agencyId = agency.getId();

		agencyAccounts.setAgency(agencyId);
		agencyAccounts.setAccounts(allAccounts);

		allAgencyAccounts.add(agencyAccounts);
	    }
	}

	return Uni.createFrom().item(allAgencyAccounts);
    }
}
