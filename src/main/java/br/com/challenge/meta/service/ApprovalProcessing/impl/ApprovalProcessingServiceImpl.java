package br.com.challenge.meta.service.ApprovalProcessing.impl;

import br.com.challenge.meta.dto.form.ApprovalProcessingForm;
import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import br.com.challenge.meta.model.ApprovalProcessing.ApprovalProcessing;
import br.com.challenge.meta.repository.ApprovalProcessingRepository;
import br.com.challenge.meta.service.ApprovalProcessing.ApprovalProcessingService;
import br.com.challenge.meta.service.User.UserService;
import br.com.challenge.meta.service.mapper.ApprovalProcessingMapper;
import br.com.challenge.meta.specification.ApprovalProcessingSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ServerErrorException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApprovalProcessingServiceImpl implements ApprovalProcessingService {

  private final ApprovalProcessingRepository repository;
  private final ApprovalProcessingMapper mapper;
  private final UserService userService;

  @Override
  public List<ApprovalProcessingDTO> findAll(ApprovalProcessingFilter filter, Pageable pageable) {
    return mapper.toDto(repository.findAll(new ApprovalProcessingSpecification(filter), pageable).getContent());
  }

  @Override
  public ApprovalProcessingDTO save(ApprovalProcessingForm form) {
    userService.findById(form.getResponsible());
    try {
      return mapper.toDto(this.persist(form));
    } catch (Exception e) {
      throw new ServerErrorException("Failed create approvalProcessing. Error: " + e.getMessage());
    }
  }

  @Override
  public ApprovalProcessingDTO update(ApprovalProcessingForm form, UUID id) {
    this.findById(id);
    try {
      return mapper.toDto(this.persist(form));
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

  private ApprovalProcessing persist(ApprovalProcessingForm form) {
    return repository.save(mapper.toEntity(form));
  }
}
