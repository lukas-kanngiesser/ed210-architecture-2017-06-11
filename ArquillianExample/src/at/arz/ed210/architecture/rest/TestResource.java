package at.arz.ed210.architecture.rest;

import java.text.MessageFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.jboss.logging.Message;

@Path("hello")
public class TestResource {

	@GET
	public Response hello(@QueryParam("name") String name) {
		return Response.ok().entity(MessageFormat.format("Hello {0}!", name)).build();
	}
}
