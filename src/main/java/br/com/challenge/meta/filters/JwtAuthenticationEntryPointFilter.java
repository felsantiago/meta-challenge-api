package br.com.challenge.meta.filters;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class that implements AuthenticationEntryPoint interface to modify the headers on the
 * <code>ServletResponse</code> as necessary to commence the authentication process and
 * customize unauthorized access responses.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Component
public class JwtAuthenticationEntryPointFilter implements AuthenticationEntryPoint {

	/**
	 * Method that implements a customization to unauthorized invalid access responses.
	 *
	 * @see AuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException
			authException) throws IOException, ServletException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Access denied. You must be authenticated on the system to access the requested URL.");
	}

}
