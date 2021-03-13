package br.com.challenge.meta.service.HangTag;

import br.com.challenge.meta.dto.model.HangTagDTO;
import br.com.challenge.meta.filter.HangTagFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface HangTagService {

  /**
   * This method is responsible for obtaining all records
   *
   * @param filter criteria
   * @param pageable pagination
   * @return List<DTO>
   */
  List<HangTagDTO> findAll(HangTagFilter filter, Pageable pageable);

  /**
   * This method is responsible for inserting a record in the database
   *
   * @param dto data to insert
   * @return DTO
   */
  HangTagDTO save(HangTagDTO dto);

  /**
   * This method is responsible for updating a record in the database
   *
   * @param dto data to update
   * @param id record id to be updated
   * @return DTO
   */
  HangTagDTO update(HangTagDTO dto, UUID id);

  /**
   * This method is responsible for removing a record in the database
   *
   * @param id record id to be deleted
   * @return Boolean
   */
  Boolean delete(UUID id);
}
