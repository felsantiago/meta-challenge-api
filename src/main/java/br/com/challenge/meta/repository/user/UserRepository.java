package br.com.challenge.meta.repository.user;

import br.com.challenge.meta.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface that implements the User Repository, with JPA CRUD methods
 * and other customized searches.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

  /**
   * Method to search an User by the email.
   *
   * @param email
   * @return Optional<User>
   * @author Felipe Santiiago
   * @since 2021-03-15
   */
  Optional<User> findByEmail(String email);
}

