package com.data.Controller;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@Path("/posts")
public class ClientController {
	private final String POST_URI = "https://jsonplaceholder.typicode.com/posts";
	private final String add_urlString = "http://localhost:8080/api/add";

	Client client = ClientBuilder.newClient();

	@GET
	@Produces("application/json")
	public List<Object> getList() {

		Object[] lisObjects = client.target(POST_URI).request(MediaType.APPLICATION_JSON).get(Object[].class);

		return Arrays.asList(lisObjects);

	}

	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Object getById() {

		Object obj = client.target(POST_URI).path("{id}").resolveTemplate("id", "1").request(MediaType.APPLICATION_JSON)
				.get(Object.class);
		return obj;
	}

	

}
