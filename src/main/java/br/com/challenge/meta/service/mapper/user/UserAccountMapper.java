package br.com.challenge.meta.service.mapper.user;

import br.com.challenge.meta.dto.model.user.UserAccountDTO;
import br.com.challenge.meta.model.user.UserAccount;
import br.com.challenge.meta.service.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAccountMapper extends EntityMapper<UserAccountDTO, UserAccount> {

  @Mapping(target = "user.id", source = "userId")
  @Mapping(target = "account.id", source = "accountId")
  UserAccount toEntity(UserAccountDTO dto);

  @Mapping(target = "userId", source = "user.id")
  @Mapping(target = "accountId", source = "account.id")
  UserAccountDTO toDto(UserAccount entity);
}