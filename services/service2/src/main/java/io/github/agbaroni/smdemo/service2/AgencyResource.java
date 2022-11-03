package io.github.agbaroni.smdemo.service1;

import io.smallrye.mutiny.Uni;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import org.hibernate.reactive.mutiny.Mutiny;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/agencies")
@Produces(MediaType.APPLICATION_JSON)
public class AgencyResource implements Serializable {
    private static final long serialVersionUID = 621718444121132667L;

    @Inject
    Mutiny.SessionFactory sessionFactory;

    @GET
    public Uni<List<Agency>> getAll() {
	return sessionFactory.withSession(session -> {
		return session.createNamedQuery(Agency.SELECT_ALL,
						Agency.class).getResultList();
	    });
    }

    @GET
    @Path("/{id}")
    public Uni<Agency> getOne(@PathParam("id") String id) {
	return sessionFactory.withSession(session -> {
		return session.createNamedQuery(Agency.SELECT_ONE,
						Agency.class).setParameter("id", id).getSingleResultOrNull();
	    });
    }
}
