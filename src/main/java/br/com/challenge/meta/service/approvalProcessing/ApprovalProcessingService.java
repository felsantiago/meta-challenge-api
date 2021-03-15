package br.com.challenge.meta.service.approvalProcessing;

import br.com.challenge.meta.dto.model.approvalProcessing.ApprovalProcessingDTO;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.specification.filter.ApprovalProcessingFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ApprovalProcessingService {

  /**
   * This method is responsible for obtaining all records
   *
   * @param filter   criteria
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
   * @return DTO
   */
  ApprovalProcessingDTO update(ApprovalProcessingDTO dto);

  /**
   * This method is responsible for removing a record in the database
   *
   * @param id record id to be deleted
   * @return Boolean
   */
  void delete(UUID id) throws ApprovalProcessingNotFoundException;
}
