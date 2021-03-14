package br.com.challenge.meta.service.ApprovalProcessing;

import br.com.challenge.meta.dto.form.ApprovalProcessingForm;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
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
   * @param form data to insert
   * @return DTO
   */
  ApprovalProcessingDTO save(ApprovalProcessingForm form);

  /**
   * This method is responsible for updating a record in the database
   *
   * @param form data to update
   * @param id record id to be updated
   * @return DTO
   */
  ApprovalProcessingDTO update(ApprovalProcessingForm form, UUID id);

  /**
   * This method is responsible for removing a record in the database
   *
   * @param id record id to be deleted
   * @return Boolean
   */
  void delete(UUID id) throws ApprovalProcessingNotFoundException;
}
