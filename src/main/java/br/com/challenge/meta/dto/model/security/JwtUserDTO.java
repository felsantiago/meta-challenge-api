package br.com.challenge.meta.dto.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Class that implements JWT Authentication data transfer object (DTO)
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserDTO {

	@NotNull(message = "Enter an email")
	@NotEmpty(message = "Enter an email")
	private String email;

	@NotNull(message = "Enter a password")
	@NotEmpty(message = "Enter a password")
	private String password;

}
