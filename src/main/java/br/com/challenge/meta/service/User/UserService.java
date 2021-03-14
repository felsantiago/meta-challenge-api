package br.com.challenge.meta.service.User;

import br.com.challenge.meta.dto.model.UserDTO;
import br.com.challenge.meta.filter.UserFilter;
import br.com.challenge.meta.model.User.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

  /**
   * This method is responsible for obtaining all records
   *
   * @param filter criteria
   * @param pageable pagination
   * @return List<DTO>
   */
  List<UserDTO> findAll(UserFilter filter, Pageable pageable);

  /**
   * This method is responsible for inserting a record in the database
   *
   * @param dto data to insert
   * @return DTO
   */
  UserDTO save(UserDTO dto);

  /**
   * This method is responsible for updating a record in the database
   *
   * @param dto data to update
   * @param id record id to be updated
   * @return DTO
   */
  UserDTO update(UserDTO dto, UUID id);

  /**
   * This method is responsible for removing a record in the database
   *
   * @param id record id to be deleted
   * @return Boolean
   */
  Boolean delete(UUID id);

  User findById(UUID id);
}
