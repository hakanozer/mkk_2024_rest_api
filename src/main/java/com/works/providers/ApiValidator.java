package com.works.providers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.List;

@Provider
public class ApiValidator implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(prepareMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private String prepareMessage(ConstraintViolationException exception) {
        List<String> validationErrorList  = new ArrayList<>();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            validationErrorList.add(cv.getPropertyPath() + ":" + cv.getMessage() );
        }
        System.out.println("error");
        return "";
    }
}
