package com.home.webshop.Controller;

import com.home.webshop.Model.User;
import com.home.webshop.Service.UserService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("user")
public class UserController {

    @Context
    private UriInfo context;

    public UserController() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    
    /*
    {
        "username": "admin",
        "email": "admin@gmail.com",
        "password": "admin123",
        "phone": "123456789",
        "surename": "Nagy",
        "forename": "Anna"
    }
    */
    
    @POST
    @Path("createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User u) {
        String result = UserService.createUser(u.getUsername(), u.getEmail(), u.getPassword(), u.getPhone(), u.getSurename(), u.getForename());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User u) {
        JSONObject result = UserService.login(u.getEmail(), u.getPassword());
        return Response.status(Response.Status.OK).entity(result.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
