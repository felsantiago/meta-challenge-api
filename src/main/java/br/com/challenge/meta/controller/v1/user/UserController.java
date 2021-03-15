package br.com.challenge.meta.controller.v1.user;

import br.com.challenge.meta.dto.model.user.UserDTO;
import br.com.challenge.meta.dto.response.Response;
import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.service.user.UserService;
import br.com.challenge.meta.util.MetaApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * SpringBoot RestController that implements all API service end-points related to the user.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

	private final UserService service;

	/**
	 * Method that creates an user in the API.
	 *
	 * @param dto
	 * @param result
	 * @return ResponseEntity with a Response<UserDTO> object and the HTTP status
	 *
	 * HTTP Status:
	 *
	 * 201 - Created: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 401 - Unauthorized: No valid API key provided.
	 * 403 - Forbidden: The API key doesn't have permissions to perform the request.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).
	 */
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@RequestHeader(value= MetaApiUtil.HEADER_META_API_VERSION, defaultValue="${api.version}")
		String apiVersion, @Valid @RequestBody UserDTO dto, BindingResult result){

		Response<UserDTO> response = new Response<>();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getAuthorities().stream()
				.noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			response.addErrorMsgToResponse("User does not have permission");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
		}

		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		User user = service.toEntity(dto);
		UserDTO userDTO = service.save(dto);

		//Self link
		createSelfLink(user, userDTO);
		response.setData(userDTO);

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);

		return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
	}

	/**
	 * Method that creates a self link to User object
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param user
	 * @param userDTO
	 */
	private void createSelfLink(User user, UserDTO userDTO) {
		Link selfLink = WebMvcLinkBuilder.linkTo(UserController.class).slash(user.getId()).withSelfRel();
		userDTO.add(selfLink);
	}

}
