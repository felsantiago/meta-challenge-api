package br.com.challenge.meta.service.account;

import br.com.challenge.meta.dto.model.account.AccountDTO;
import br.com.challenge.meta.exception.AccountNotFoundException;
import br.com.challenge.meta.model.account.Account;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface that provides methods for manipulating Account objects.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public interface AccountService {

	/**
	 * Method that saves an account in the database.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param dto
	 * @return <code>Account</code> object
	 */
	AccountDTO save(AccountDTO dto);

	/**
	 * Method that find an account by accountNumber in the database.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param accountNumber
	 * @return Optional<Account> object
	 */
	Optional<AccountDTO> findByAccountNumber(String accountNumber) throws AccountNotFoundException;

	/**
	 * Method that find a account by an id.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param accountId
	 * @return <code>Optional<Account></code> object
	 */
	AccountDTO findById(UUID accountId) throws AccountNotFoundException;

	Account toEntity(AccountDTO dto);

}
