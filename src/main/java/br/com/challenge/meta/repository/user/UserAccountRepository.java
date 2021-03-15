package br.com.challenge.meta.repository.user;

import br.com.challenge.meta.model.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface that implements the User Account Repository, with JPA CRUD methods
 * and other customized searches.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, UUID>, JpaSpecificationExecutor<UserAccount> {

  /**
   * Method to search an UserAccount by user's id and account id.
   *
   * @param user
   * @param account
   * @return Optional<UserAccount>
   * @author Felipe Santiiago
   * @since 2021-03-15
   */
  Optional<UserAccount> findByUserIdAndAccountId(Long user, Long account);
}