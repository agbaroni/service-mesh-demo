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
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource implements Serializable {
    private static final long serialVersionUID = 4815202253117727649L;

    @Inject
    Mutiny.SessionFactory sessionFactory;

    @GET
    @Path("/{user}")
    public Uni<List<Account>> getAll(@PathParam("user") String user) {
	return sessionFactory.withSession(session -> {
		return session.createNamedQuery(Account.SELECT_ALL,
						Account.class).setParameter("user",
									    user).getResultList();
	    });
    }

    @GET
    @Path("/{user}/{account}")
    public Uni<Account> getOne(@PathParam("user") String user,
			       @PathParam("account") String account) {
	return sessionFactory.withSession(session -> {
		return session.createNamedQuery(Account.SELECT_ONE,
						Account.class).setParameter("id",
									    account)
		    .setParameter("user", user).getSingleResultOrNull();
	    });
    }

    @PUT
    @Path("/{user}/{account}")
    public Uni<Account> updateOne(@PathParam("user") String user,
				  @PathParam("account") String account) {
	return null;
    }
}
