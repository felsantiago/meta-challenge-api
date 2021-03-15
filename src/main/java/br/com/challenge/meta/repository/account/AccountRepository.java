package br.com.challenge.meta.repository.account;

import br.com.challenge.meta.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface that implements the Account Repository, with JPA CRUD methods.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account> {

  /**
   * Method to search an Account by the account number.
   *
   * @param accountNumber
   * @return Optional<Account>
   * @author Felipe Santiiago
   * @since 2021-03-15
   */
  Optional<Account> findByAccountNumber(String accountNumber);
}
