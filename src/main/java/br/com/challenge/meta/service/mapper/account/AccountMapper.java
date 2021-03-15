package br.com.challenge.meta.service.mapper.account;

import br.com.challenge.meta.dto.model.account.AccountDTO;
import br.com.challenge.meta.model.account.Account;
import br.com.challenge.meta.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {
}