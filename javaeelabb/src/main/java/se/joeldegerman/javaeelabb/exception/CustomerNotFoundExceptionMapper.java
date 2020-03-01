package se.joeldegerman.javaeelabb.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomerNotFoundExceptionMapper implements ExceptionMapper<CustomerNotFoundException>{

	@Override
	public Response toResponse(CustomerNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404);
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
