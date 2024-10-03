package com.works.restcontrollers;

import com.works.entities.User;
import com.works.models.Search;
import com.works.services.UserService;
import com.works.utls.Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

@Path("user")
@Consumes("application/json")
@Produces("application/json")
public class UserRestController {

    private final UserService userService;
    public UserRestController() {
        userService = new UserService();
    }

    @POST
    @Path("login")
    public Response login( @Valid User user ) {
        return userService.login(user);
    }

    @GET
    @Path("search")
    public Response search() {
        return Util.success("search");
    }


}
