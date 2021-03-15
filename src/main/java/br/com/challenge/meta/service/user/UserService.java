package br.com.challenge.meta.service.user;

import br.com.challenge.meta.dto.model.user.UserDTO;
import br.com.challenge.meta.model.user.User;

import java.util.Optional;

/**
 * Interface that provides methods for manipulating User objects.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public interface UserService {

	/**
	 * Method that saves an user in the database.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param dto
	 * @return User object
	 */
	UserDTO save(UserDTO dto);

	/**
	 * Method that find an user by email in the database.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param email
	 * @return Optional<User> object
	 */
	Optional<User> findByEmail(String email);

	User toEntity(UserDTO dto);
}
