package com.works.utls;

import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {

    public static Response success( Object obj ) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "ok");
        map.put("message", "success");
        map.put("result", obj);
        return Response.ok().entity(map).build();
    }

    public static Response fail(Object obj, Response.StatusType status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "false");
        map.put("message", "fail message");
        map.put("result", obj);
        return Response.status(status).entity(map).build();
    }

}
