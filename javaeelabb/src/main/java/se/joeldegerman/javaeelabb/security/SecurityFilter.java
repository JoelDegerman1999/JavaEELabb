package se.joeldegerman.javaeelabb.security;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

//@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if (authHeader != null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			byte[] decodedBytes = Base64.getUrlDecoder().decode(authToken);
			String decodedUrl = new String(decodedBytes);
			StringTokenizer tokenizer = new StringTokenizer(decodedUrl, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();

			if (username.equals("user") && password.equals("pass")) {
				return;
			}

		}
		Response unauthorizedStatus = Response.status(Status.UNAUTHORIZED).entity("User can not access this").build();

		requestContext.abortWith(unauthorizedStatus);

	}

}
