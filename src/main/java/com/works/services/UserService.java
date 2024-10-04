package com.works.services;

import com.works.entities.User;
import com.works.utls.Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

public class UserService {

    public Response login(User user) {
        try {
           return Util.success(user);
        }catch (Exception ex) {
            return Util.fail("Fail Obj", Response.Status.BAD_REQUEST);
        }
    }

}
