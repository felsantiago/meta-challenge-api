package br.com.challenge.meta.service.HangTag.impl;

import br.com.challenge.meta.dto.model.HangTagDTO;
import br.com.challenge.meta.filter.HangTagFilter;
import br.com.challenge.meta.service.HangTag.HangTagService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HangTagServiceImpl implements HangTagService {
  @Override
  public List<HangTagDTO> findAll(HangTagFilter filter, Pageable pageable) {
    return null;
  }

  @Override
  public HangTagDTO save(HangTagDTO dto) {
    return null;
  }

  @Override
  public HangTagDTO update(HangTagDTO dto, UUID id) {
    return null;
  }

  @Override
  public Boolean delete(UUID id) {
    return null;
  }
}
