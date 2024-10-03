package com.works.restcontrollers;

import com.works.entities.User;
import com.works.services.UserService;
import com.works.utls.Util;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("user")
public class UserRestController {

    private final UserService userService;
    public UserRestController() {
        userService = new UserService();
    }

    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login( User user ) {
        return userService.login(user);
    }


}
