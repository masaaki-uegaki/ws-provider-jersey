package ws.sample.jersey;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ws.sample.jersey.User;

/**
 * Root resource (exposed at "users" path)
 */
@Path("users")
public class UserService {
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getIt(@QueryParam("id") String id) {
    	if (!"001".equals(id)) {
    		throw new WebApplicationException("そんな奴いない！", Response.Status.BAD_REQUEST);
    	}
    	User user = new User("001", "うえがき");
        return user;
    }

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt2() {
//        return "表示おっけー";
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postIt(User user) {
    	if (!"001".equals(user.getId())) {
    		throw new WebApplicationException("そんな奴いない！", Response.Status.BAD_REQUEST);
    	}
    	System.out.println("server");
    	System.out.println(user.getId());
    	System.out.println(user.getName());
    }
}
