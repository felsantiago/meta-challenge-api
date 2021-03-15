package br.com.challenge.meta.service.account.impl;

import br.com.challenge.meta.dto.model.account.AccountDTO;
import br.com.challenge.meta.exception.AccountNotFoundException;
import br.com.challenge.meta.model.account.Account;
import br.com.challenge.meta.repository.account.AccountRepository;
import br.com.challenge.meta.service.account.AccountService;
import br.com.challenge.meta.service.mapper.account.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.Optional;
import java.util.UUID;

/**
 * Class that implements the account service methods
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountMapper mapper;
  private final AccountRepository repository;

  /**
   * @see AccountService#save(AccountDTO)
   */
  @Override
  public AccountDTO save(AccountDTO dto) {
    try {
      return mapper.toDto(repository.save(mapper.toEntity(dto)));
    } catch (Exception e) {
      throw new ServerErrorException("Failed create approvalProcessing. Error: " + e.getMessage());
    }
  }

  /**
   * @see AccountService#findByAccountNumber(String)
   */
  @Override
  public Optional<AccountDTO> findByAccountNumber(String accountNumber) throws AccountNotFoundException {
    Optional<Account> accounts = repository.findByAccountNumber(accountNumber);

    if (!accounts.isPresent()) {
      throw new AccountNotFoundException("There are no accounts registered with the accountNumber=" + accountNumber);
    }

    return Optional.ofNullable(mapper.toDto(accounts.get()));
  }

  /**
   * @see AccountService#findById(UUID)
   */
  @Override
  public AccountDTO findById(UUID accountId) throws AccountNotFoundException {
    return repository.findById(accountId).map(mapper::toDto).orElseThrow(() -> new AccountNotFoundException("Account not found"));
  }

  @Override
  public Account toEntity(AccountDTO dto) {
    return mapper.toEntity(dto);
  }

}
