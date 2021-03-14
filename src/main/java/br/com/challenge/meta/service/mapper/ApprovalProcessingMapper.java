package br.com.challenge.meta.service.mapper;

import br.com.challenge.meta.dto.form.ApprovalProcessingForm;
import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.model.ApprovalProcessing.ApprovalProcessing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApprovalProcessingMapper extends EntityMapper<ApprovalProcessingDTO, ApprovalProcessing> {
  @Mapping(target = "responsible.id", source = "responsible")
  ApprovalProcessing toEntity(ApprovalProcessingForm form);
}