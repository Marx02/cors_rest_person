
package dk.webtrade.spa_cors_demo.rest;

import com.google.gson.Gson;
import dk.webtrade.spa_cors_demo.data.DataFacade;
import dk.webtrade.spa_cors_demo.entity.Person;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("person")
public class PersonResource {

    DataFacade df = new DataFacade();
    Gson gson = new Gson();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of
     * dk.webtrade.spa_cors_demo.PersonResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPersons() {
//        //TODO return proper representation object
//        return Response.ok().entity(gson.toJson(df.getAllPersons())).build();
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        //TODO return proper representation object
        return Response.ok()
                //                .header("Access-Control-Allow-Origin", "*")
                //                .header("Access-Control-Allow-Credentials", "true")
                //                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                //                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(gson.toJson(df.getAllPersons())).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        //TODO return proper representation object
        return Response.ok().entity(gson.toJson(df.getPerson(id))).build();
    }

    @GET
    @Path("/allasarray")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerson(@PathParam("id") int id) {
        //TODO return proper representation object
        return Response.ok().entity(gson.toJson(df.getAllPersons().values())).build();
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPerson(String content) {
        Person p = gson.fromJson(content, Person.class);
        df.addPerson(p);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id") int id) {
        Person p = df.removePerson(id);
        return Response.ok().entity(gson.toJson(p)).build();
    }

}
