package br.com.challenge.meta.service.mapper.approvalProcessing;

import br.com.challenge.meta.dto.model.approvalProcessing.ApprovalProcessingDTO;
import br.com.challenge.meta.dto.model.user.UserAccountDTO;
import br.com.challenge.meta.model.approvalProcessing.ApprovalProcessing;
import br.com.challenge.meta.model.user.UserAccount;
import br.com.challenge.meta.service.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApprovalProcessingMapper extends EntityMapper<ApprovalProcessingDTO, ApprovalProcessing> {

  @Mapping(target = "account.id", source = "accountId")
  ApprovalProcessing toEntity(ApprovalProcessingDTO dto);

}