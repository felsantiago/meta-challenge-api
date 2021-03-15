package br.com.challenge.meta.service.user.impl;

import br.com.challenge.meta.dto.model.user.UserAccountDTO;
import br.com.challenge.meta.model.user.UserAccount;
import br.com.challenge.meta.repository.user.UserAccountRepository;
import br.com.challenge.meta.service.mapper.user.UserAccountMapper;
import br.com.challenge.meta.service.user.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.Optional;

/**
 * Class that implements the user's account service methods
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

  private final UserAccountMapper mapper;
  private final UserAccountRepository repository;

  /**
   * @see UserAccountService#save(UserAccountDTO)
   */
  @Override
  public UserAccountDTO save(UserAccountDTO dto) {
    try {
      return mapper.toDto(repository.save(mapper.toEntity(dto)));
    } catch (Exception e) {
      throw new ServerErrorException("Failed create userAccount. Error: " + e.getMessage());
    }
  }

  /**
   * @see UserAccountService#findByUserIdAndAccountId(Long, Long)
   */
  @Override
  public Optional<UserAccount> findByUserIdAndAccountId(Long user, Long account) {
    return repository.findByUserIdAndAccountId(user, account);
  }

  @Override
  public UserAccount toEntity(UserAccountDTO dto) {
    return mapper.toEntity(dto);
  }
}
