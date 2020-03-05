package se.joeldegerman.javaeelabb.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException>{

	@Override
	public Response toResponse(UnrecognizedPropertyException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 400);
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}

}
