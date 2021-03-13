package br.com.challenge.meta.service.ApprovalProcessing;

import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ApprovalProcessingService {

  /**
   * This method is responsible for obtaining all records
   *
   * @param filter criteria
   * @param pageable pagination
   * @return List<DTO>
   */
  List<ApprovalProcessingDTO> findAll(ApprovalProcessingFilter filter, Pageable pageable);

  /**
   * This method is responsible for inserting a record in the database
   *
   * @param dto data to insert
   * @return DTO
   */
  ApprovalProcessingDTO save(ApprovalProcessingDTO dto);

  /**
   * This method is responsible for updating a record in the database
   *
   * @param dto data to update
   * @param id record id to be updated
   * @return DTO
   */
  ApprovalProcessingDTO update(ApprovalProcessingDTO dto, UUID id);

  /**
   * This method is responsible for removing a record in the database
   *
   * @param id record id to be deleted
   * @return Boolean
   */
  Boolean delete(UUID id);
}
