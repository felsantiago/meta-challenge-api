package br.com.challenge.meta.service.user;

import br.com.challenge.meta.dto.model.user.UserAccountDTO;
import br.com.challenge.meta.model.user.UserAccount;

import java.util.Optional;

/**
 * Interface that provides methods for manipulating User Account objects.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public interface UserAccountService {

	/**
	 * Method that saves an User Account in the database.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param dto
	 * @return UserAccount object
	 */
	UserAccountDTO save(UserAccountDTO dto);

	/**
	 * Method that find an UserAccount by user's id and account's id.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param user
	 * @param account
	 * @return Optional<UserAccount>
	 */
	Optional<UserAccount> findByUserIdAndAccountId(Long user, Long account);

	UserAccount toEntity(UserAccountDTO dto);
}
