package br.com.challenge.meta.service.approvalProcessing.impl;

import br.com.challenge.meta.dto.model.approvalProcessing.ApprovalProcessingDTO;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingInvalidUpdateException;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.model.approvalProcessing.ApprovalProcessing;
import br.com.challenge.meta.repository.ApprovalProcessing.ApprovalProcessingRepository;
import br.com.challenge.meta.service.approvalProcessing.ApprovalProcessingService;
import br.com.challenge.meta.service.mapper.approvalProcessing.ApprovalProcessingMapper;
import br.com.challenge.meta.specification.ApprovalProcessingSpecification;
import br.com.challenge.meta.specification.filter.ApprovalProcessingFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApprovalProcessingServiceImpl implements ApprovalProcessingService {

  private final ApprovalProcessingRepository repository;
  private final ApprovalProcessingMapper mapper;

  @Override
  public List<ApprovalProcessingDTO> findAll(ApprovalProcessingFilter filter, Pageable pageable) {
    return mapper.toDto(repository.findAll(new ApprovalProcessingSpecification(filter), pageable).getContent());
  }

  @Override
  public ApprovalProcessingDTO save(ApprovalProcessingDTO dto) {
    try {
      return mapper.toDto(this.persist(mapper.toEntity(dto)));
    } catch (Exception e) {
      throw new ServerErrorException("Failed create approvalProcessing. Error: " + e.getMessage());
    }
  }

  @Override
  public ApprovalProcessingDTO update(ApprovalProcessingDTO dto) {
    ApprovalProcessing approvalProcessing = this.findById(dto.getId());

    if (approvalProcessing.getId().compareTo(dto.getId()) != 0) {
      throw new ApprovalProcessingInvalidUpdateException("You don't have permission to change the approval processing id=" + dto.getId());
    }

    try {
      return mapper.toDto(this.persist(mapper.toEntity(dto)));
    } catch (Exception e) {
      throw new ServerErrorException("Failed update approvalProcessing. Error: " + e.getMessage());
    }
  }

  @Override
  public void delete(UUID id) {
    this.findById(id);
    try {
      this.repository.deleteById(id);
    } catch (Exception e) {
      throw new ServerErrorException("Failed delete approvalProcessing. Error: " + e.getMessage());
    }
  }

  private ApprovalProcessing findById(UUID id) {
    return this.repository.findById(id)
        .orElseThrow(() -> new ApprovalProcessingNotFoundException("Register not found."));
  }

  private ApprovalProcessing persist(ApprovalProcessing entity) {
    return repository.save(entity);
  }
}
