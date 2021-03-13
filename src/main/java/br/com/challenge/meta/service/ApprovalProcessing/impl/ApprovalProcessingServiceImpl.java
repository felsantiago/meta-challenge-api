package br.com.challenge.meta.service.ApprovalProcessing.impl;

import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import br.com.challenge.meta.service.ApprovalProcessing.ApprovalProcessingService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApprovalProcessingServiceImpl implements ApprovalProcessingService {
  @Override
  public List<ApprovalProcessingDTO> findAll(ApprovalProcessingFilter filter, Pageable pageable) {
    return null;
  }

  @Override
  public ApprovalProcessingDTO save(ApprovalProcessingDTO dto) {
    return null;
  }

  @Override
  public ApprovalProcessingDTO update(ApprovalProcessingDTO dto, UUID id) {
    return null;
  }

  @Override
  public Boolean delete(UUID id) {
    return null;
  }
}
