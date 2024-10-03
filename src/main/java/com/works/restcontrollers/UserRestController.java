package com.works.restcontrollers;

import com.works.entities.User;
import com.works.models.Search;
import com.works.services.UserService;
import com.works.utls.Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import lombok.Getter;

@Path("user")
@Consumes("application/json")
@Produces("application/json")
public class UserRestController {

    @Context
    UriInfo uriInfo;

    private final UserService userService;
    public UserRestController() {
        userService = new UserService();
    }

    @POST
    @Path("login")
    public Response login( @Valid User user ) {
        System.out.println(uriInfo.getAbsolutePath());
        return userService.login(user);
    }

    @GET
    @Path("search")
    public Response search() {
        return Util.success("search");
    }


}
