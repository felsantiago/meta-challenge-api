package br.com.challenge.meta.dto.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class that implements Token data transfer object (DTO)
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@AllArgsConstructor
public class TokenDTO {

	@Getter
	private String token;

}
